package edu.pitt.medschool.service;

import edu.pitt.medschool.config.InfluxappConfig;
import edu.pitt.medschool.framework.influxdb.InfluxUtil;
import edu.pitt.medschool.framework.influxdb.ResultTable;
import edu.pitt.medschool.framework.util.Util;
import edu.pitt.medschool.model.dao.AggregationDao;
import edu.pitt.medschool.model.dao.ExportDao;
import edu.pitt.medschool.model.dao.ImportedFileDao;
import edu.pitt.medschool.model.dao.VersionDao;
import edu.pitt.medschool.model.dto.AggregationDatabase;
import edu.pitt.medschool.model.dto.AggregationDatabaseWithBLOBs;

import edu.pitt.medschool.model.dto.AggregationDb;
import okhttp3.OkHttpClient;
import org.apache.poi.ss.usermodel.DataFormat;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.text.DecimalFormat;

import static edu.pitt.medschool.framework.influxdb.InfluxUtil.generateIdbClient;

@Service
public class AggregationService {
    @Value("${load}")
    private double loadFactor;
    @Value("${soft-timeout}")
    private double softTimeOut;
    @Value("${soft-timeout-sleep}")
    private long timeoutSleep;

    private BufferedWriter bufferedWriter;
    private String dir;

    @Autowired
    ExportDao exportDao;
    @Autowired
    ImportedFileDao importedFileDao;
    @Autowired
    ValidateCsvService validateCsvService;
    @Autowired
    VersionDao versionDao;
    @Autowired
    AggregationDao aggregationDao;

    //todo version control needs to change the db name
    private final String DBNAME_1H = "sixty_minute_summary_V";
    private final String DBNAME_1M = "one_minute_summary_V";
    private final String DBNAME_5M = "five_minute_summary_V";
    private final String DBNAME_15M = "fifteen_minute_summary_V";
    private final String DBNAME_30M = "thirty_minute_summary_V";
    private final String DBNAME_10M = "ten_minute_summary_V";
    private final int MAXBATCH = 5;
    private final DecimalFormat DIGIT = new   java.text.DecimalFormat("#.00");

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LinkedBlockingQueue<AggregationDb> jobQueue = new LinkedBlockingQueue<>();
    private final ScheduledFuture<?> jobCheckerThread;

    @Autowired
    public AggregationService() {
        this.jobCheckerThread = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            Thread.currentThread().setName("JobCheckerThread");
            AggregationDb target = null;
            while ((target = this.jobQueue.poll()) != null) {
                logger.info("Start to process job #<{}>", target.getId());

//                startAgg(target);
                startEfficentAgg(target);

                logger.info("Finished one job #<{}>", target.getId());
            }
        }, 10, 20, TimeUnit.SECONDS);
    }


    // todo add version condition into aggregation query

//    private void startAgg(AggregationDatabaseWithBLOBs job){
//        System.out.println("start aggregation");
//        String time = getAggTime(job.getAggregateTime());
//        final String DIR = "aggregationDBLog";
//
//
//        List<String> patientIDs;
//        String plist = job.getPidList();
//
//        if(plist == null || plist.isEmpty()){
//            //todo new way to get all pids from csv_file table
//            patientIDs = importedFileDao.selectAllImportedPidWithoutTBI("realpsc");
//        }else {
//            patientIDs = Arrays.asList(job.getPidList().split(","));
//        }
//
//        // todo update total
//        List<String> patients = new ArrayList<>();
//
//        // recover job after break down
//        //get finished pids
//        String pathname = "/tsdb/output/"+DIR+"/"+job.getDbName()+".txt";
//        File filename = new File(pathname);
//        if(filename.exists()){
//            try{
//                InputStreamReader reader = new InputStreamReader(
//                        new FileInputStream(filename));
//                BufferedReader br = new BufferedReader(reader);
//                HashSet<String> finishedPid = new HashSet<>();
//                String line = br.readLine();
//                while (line != null) {
//                    String[] record = line.split(":");
//                    if(record[0].equals("Success")){
//                        finishedPid.add(record[1].trim());
//                    }
//                    line = br.readLine();
//                }
//                HashSet<String> allPid = new HashSet<>(patientIDs);
//                allPid.removeAll(finishedPid);
//                patients = new ArrayList<>(allPid);
////                System.out.println(finishedPid.size());
////                System.out.println(allPid.size());
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }else{
//            patients = patientIDs;
//        }
//
//        // update the total number of patients of this job
//        aggregationDao.updateTotalnumber(job.getId(),patients.size());
//
//        // count the finished number
//        AtomicInteger finishedPatientCounter = new AtomicInteger(0);
//        BlockingQueue<String> idQueue = new LinkedBlockingQueue<>(patients);
//
//        // get all 6037 columns
//        List<String> columns = getColumns();
//
//        // get selection condition from 6037 columns, now each file is splited into 9 parts
//        List<String> selection = getSelection(columns,job);
//        int paraCount = job.getThreads();
//        ExecutorService scheduler = generateNewThreadPool(paraCount);
//        try{
//            this.bufferedWriter = new BufferedWriter(new FileWriter(pathname,true));
//            this.bufferedWriter.write("Cores: "+paraCount);
//            this.bufferedWriter.newLine();
//            this.bufferedWriter.flush();
//            InfluxDB influxDB = generateIdbClient(false);
//            String command = "create database " + job.getDbName();
//            influxDB.query(new Query(command));
//            influxDB.close();
//        }catch (IOException e){
//            e.printStackTrace();
//            return;
//        }
//
//        LocalDateTime start_Time = LocalDateTime.now();
//        Runnable queryTask = () -> {
//            String pid;
//            InfluxDB influxDB = generateIdbClient(false);
//            while ((pid=idQueue.poll())!=null){
//                try{
//                    // generate query
////                    QueryResult res1 = influxDB.query(new Query(String.format("select first(\"max_I1_1\") from \"%s\" where arType='ar'", pid),"aggdata"));
////                    QueryResult res2 = influxDB.query(new Query(String.format("select last(\"max_I1_1\") from \"%s\" where arType='ar'", pid),"aggdata"));
//
//                    //to generate the first 6h
//                    String i11 = job.getFromDb().equals("data")?"I1_1":"max_I1_1";
//                    QueryResult res1 = influxDB.query(new Query(String.format("select first(\"%s\") from \"%s\" where arType='ar'",i11, pid),job.getFromDb()));
//
//
//                    //QueryResult res2 = influxDB.query(new Query(String.format("select last(\"I1_1\") from \"%s\" where arType='ar'", pid),"data"));
//                    String startTime = res1.getResults().get(0).getSeries().get(0).getValues().get(0).get(0).toString();
//                    // only do 7 hours
//                    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//                    String endTime = LocalDateTime.parse(startTime,df).plusHours(7).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
////                    System.out.println(startTime);
////                    System.out.println(endTime);
//
//                    // to do the next 7h.
//                    for(int i=0;i<0;i++){
//                        startTime = endTime;
//                        endTime = LocalDateTime.parse(startTime,df).plusHours(7).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
//                    }
//                    List<String> queries = new ArrayList<>();
//                    for(int count=0;count<selection.size();count++){
//                        //queries.add(String.format("select %s into \"%s\".\"autogen\".\"%s\" from \"%s\" where arType='ar' AND time<='%s' AND time>='%s' group by time(%s), arType", selection.get(count), job.getDbName().replace(" ","_")+"_V"+job.getVersion(),pid, pid,endTime,startTime,time));
////                        queries.add(String.format("select %s into \"%s\".\"autogen\".\"%s\" from \"%s\" where arType='ar' AND time<='%s' AND time>='%s' group by time(%s), arType", selection.get(count), "aggdata",pid, pid,endTime,startTime,time));
//                        queries.add(String.format("select %s into \"%s\".\"autogen\".\"%s\" from \"%s\" where arType='ar' AND time<'%s' AND time>='%s' group by time(%s), arType", selection.get(count), job.getDbName(),pid, pid,endTime,startTime,time));
//                    }
//
//                    // run query
//                    for(int count=0;count<selection.size();count++){
//                        //QueryResult rs = influxDB.query(new Query(queries.get(count),"aggdata"));
//                        QueryResult rs = influxDB.query(new Query(queries.get(count),job.getFromDb()));
////                        System.out.println(queries.get(count));
//                    }
//                    this.bufferedWriter.write("Success: "+pid);
//                    this.bufferedWriter.newLine();
//                    this.bufferedWriter.flush();
//                    finishedPatientCounter.getAndIncrement();
//                    aggregationDao.updatePatientFinishedNum(job.getId(),finishedPatientCounter.get());
//
//                }catch (Exception e){
//                    logger.info(pid);
//                    recordError(pid,e);
//                    finishedPatientCounter.getAndIncrement();
//                    aggregationDao.updatePatientFinishedNum(job.getId(),finishedPatientCounter.get());
//                    e.printStackTrace();
//                }
//            }
//            influxDB.close();
//        };
//
//        for (int i = 0; i < paraCount; ++i) {
//            scheduler.submit(queryTask);
//        }
//        scheduler.shutdown();
//        try {
//            scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            logger.error(Util.stackTraceErrorToString(e));
//        }
//        finally {
//            try{
//                LocalDateTime end_Time = LocalDateTime.now();
//                this.bufferedWriter.write(String.valueOf(Duration.between(start_Time,end_Time)).replace("PT","Run Time: "));
//                this.bufferedWriter.newLine();
//                this.bufferedWriter.flush();
//                this.bufferedWriter.close();
//                System.out.println("Job finished");
//                aggregationDao.updateStatus(job.getId(),"Success");
//                aggregationDao.updateTimeCost(job.getId(),String.valueOf(Duration.between(start_Time,end_Time)));
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//
//
//    }


    private void startEfficentAgg(AggregationDb job){
        System.out.println("start efficient aggregation");
        final String DIR = "aggregationDBLog";

        List<String> patientIDs;
        String plist = job.getPidList();

        if(plist == null || plist.isEmpty()){
            //todo new way to get all pids from csv_file table
            patientIDs = importedFileDao.selectAllImportedPidWithoutTBI("realpsc");
        }else {
            patientIDs = Arrays.asList(job.getPidList().split(","));
        }

        // todo update total
        List<String> patients = new ArrayList<>();
        // recover job after break down
        //get finished pids
        String pathname = "/tsdb/output/"+DIR+"/V"+job.getVersion()+"_"+job.getNday()+"day.txt";
        File filename = new File(pathname);
        if(filename.exists()){
            try{
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream(filename));
                BufferedReader br = new BufferedReader(reader);
                HashSet<String> finishedPid = new HashSet<>();
                String line = br.readLine();
                while (line != null) {
                    String[] record = line.split(":");
                    if(record[0].equals("Success")){
                        finishedPid.add(record[1].trim());
                    }
                    line = br.readLine();
                }
                HashSet<String> allPid = new HashSet<>(patientIDs);
                allPid.removeAll(finishedPid);
                patients = new ArrayList<>(allPid);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            patients = patientIDs;
        }
        // update the total number of patients of this job
        aggregationDao.updateTotalnumber(job.getId(),patients.size());

        // count the finished number
        AtomicInteger finishedPatientCounter = new AtomicInteger(0);
        BlockingQueue<String> idQueue = new LinkedBlockingQueue<>(patients);
        
        // get all 6037 columns
        // List<String> columns = getColumns();
        // // get selection condition from 6037 columns, now each file is splited into 9 parts
        // List<String> selection = getSelection(columns,job);
        // int paraCount = job.getThreads();



        int paraCount = determineParaNumber();
        ExecutorService scheduler = generateNewThreadPool(paraCount);
        try{
            this.bufferedWriter = new BufferedWriter(new FileWriter(pathname,true));
            this.bufferedWriter.write("Cores: "+paraCount);
            this.bufferedWriter.newLine();
            this.bufferedWriter.flush();

//            InfluxDB influxDB = generateIdbClient(false);
//            String command = "create database " + job.getDbName();
//            influxDB.query(new Query(command));
//            influxDB.close();

        }catch (IOException e){
            e.printStackTrace();
            return;
        }

        LocalDateTime start_Time = LocalDateTime.now();

        Runnable queryTask = () -> {
            String pid;
            InfluxDB influxDB = generateIdbClient(false);
            while ((pid=idQueue.poll())!=null){
                try{
                    // generate query
//                    QueryResult res1 = influxDB.query(new Query(String.format("select first(\"max_I1_1\") from \"%s\" where arType='ar'", pid),"aggdata"));
//                    QueryResult res2 = influxDB.query(new Query(String.format("select last(\"max_I1_1\") from \"%s\" where arType='ar'", pid),"aggdata"));


                    //to generate the first 6h
                    // String i11 = job.getFromDb().equals("data")?"I1_1":"max_I1_1";
                    // QueryResult res1 = influxDB.query(new Query(String.format("select first(\"%s\") from \"%s\" where arType='ar'",i11, pid),job.getFromDb()));


                    // //QueryResult res2 = influxDB.query(new Query(String.format("select last(\"I1_1\") from \"%s\" where arType='ar'", pid),"data"));
                    // System.out.println(String.format("select first(\"%s\") from \"%s\" where arType='ar'",i11, pid));

                    QueryResult res1 = influxDB.query(new Query(String.format("select first(\"I1_1\") from \"%s\" where arType='ar'", pid),"data"));
                    QueryResult res2 = influxDB.query(new Query(String.format("select last(\"I1_1\") from \"%s\" where arType='ar'", pid),"data"));
                    String startTime = res1.getResults().get(0).getSeries().get(0).getValues().get(0).get(0).toString();
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
// <<<<<<< 
//                     String endTime = LocalDateTime.parse(startTime,df).plusHours(7).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";

//                     System.out.println(startTime);
//                     System.out.println(endTime);

//                     List<String> queries = new ArrayList<>();
//                     System.out.println(selection.size());
//                     for(int count=0;count<selection.size();count++){
//                     	//System.out.println(String.format("select %s into \"%s\".\"autogen\".\"%s\" from \"%s\" where arType='ar' AND time<='%s' AND time>='%s' group by time(%s), arType", selection.get(count), job.getDbName(),pid, pid,endTime,startTime,time));
//                         //queries.add(String.format("select %s into \"%s\".\"autogen\".\"%s\" from \"%s\" where arType='ar' AND time<='%s' AND time>='%s' group by time(%s), arType", selection.get(count), job.getDbName().replace(" ","_")+"_V"+job.getVersion(),pid, pid,endTime,startTime,time));
// //                        queries.add(String.format("select %s into \"%s\".\"autogen\".\"%s\" from \"%s\" where arType='ar' AND time<='%s' AND time>='%s' group by time(%s), arType", selection.get(count), "aggdata",pid, pid,endTime,startTime,time));
//                         queries.add(String.format("select %s into \"%s\".\"autogen\".\"%s\" from \"%s\" where arType='ar' AND time<'%s' AND time>='%s' group by time(%s), arType", selection.get(count), job.getDbName(),pid, pid,endTime,startTime,time));
//                     }

//                     // run query
//                     for(int count=0;count<selection.size();count++){
//                         //QueryResult rs = influxDB.query(new Query(queries.get(count),"aggdata"));
//                         QueryResult rs = influxDB.query(new Query(queries.get(count),job.getFromDb()));
// //                        System.out.println(queries.get(count));
//                     }
//                     this.bufferedWriter.write("Success: "+pid);
//                     this.bufferedWriter.newLine();
//                     this.bufferedWriter.flush();
//                     finishedPatientCounter.getAndIncrement();
//                     aggregationDao.updatePatientFinishedNum(job.getId(),finishedPatientCounter.get());

//                 }catch (Exception e){
//                     logger.info(pid);
//                     recordError(pid,e);
//                     finishedPatientCounter.getAndIncrement();
//                     aggregationDao.updatePatientFinishedNum(job.getId(),finishedPatientCounter.get());
//                     e.printStackTrace();
//                 }
//             }
//             influxDB.close();
//         };

//         for (int i = 0; i < paraCount; ++i) {
//             scheduler.submit(queryTask);
//         }
//         scheduler.shutdown();
//         try {
//             scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
//         } catch (InterruptedException e) {
//             logger.error(Util.stackTraceErrorToString(e));
//         }
//         finally {
//             try{
//                 LocalDateTime end_Time = LocalDateTime.now();
//                 this.bufferedWriter.write(String.valueOf(Duration.between(start_Time,end_Time)).replace("PT","Run Time: "));
//                 this.bufferedWriter.newLine();
//                 this.bufferedWriter.flush();
//                 this.bufferedWriter.close();
//                 System.out.println("Job finished");
//                 aggregationDao.updateStatus(job.getId(),"Success");
//                 aggregationDao.updateTimeCost(job.getId(),String.valueOf(Duration.between(start_Time,end_Time)));
//             }catch (IOException e){
//                 e.printStackTrace();
//             }
//         }


//     }


//     private void startEfficentAgg(AggregationDatabaseWithBLOBs job){
//         System.out.println("start efficient aggregation");
//         final String DIR = "aggregationDBLog";

//         List<String> patientIDs;
//         String plist = job.getPidList();

//         if(plist == null || plist.isEmpty()){
//             //todo new way to get all pids from csv_file table
//             patientIDs = importedFileDao.selectAllImportedPidWithoutTBI("realpsc");
//         }else {
//             patientIDs = Arrays.asList(job.getPidList().split(","));
//         }

//         // todo update total
//         List<String> patients = new ArrayList<>();

//         // recover job after break down
//         //get finished pids
//         String pathname = "/tsdb/output/"+DIR+"/"+job.getDbName()+".txt";
//         File filename = new File(pathname);
//         if(filename.exists()){
//             try{
//                 InputStreamReader reader = new InputStreamReader(
//                         new FileInputStream(filename));
//                 BufferedReader br = new BufferedReader(reader);
//                 HashSet<String> finishedPid = new HashSet<>();
//                 String line = br.readLine();
//                 while (line != null) {
//                     String[] record = line.split(":");
//                     if(record[0].equals("Success")){
//                         finishedPid.add(record[1].trim());
//                     }
//                     line = br.readLine();
//                 }
//                 HashSet<String> allPid = new HashSet<>(patientIDs);
//                 allPid.removeAll(finishedPid);
//                 patients = new ArrayList<>(allPid);
// //                System.out.println(finishedPid.size());
// //                System.out.println(allPid.size());
//             }catch (IOException e){
//                 e.printStackTrace();
//             }
//         }else{
//             patients = patientIDs;
//         }

//         // update the total number of patients of this job
//         aggregationDao.updateTotalnumber(job.getId(),patients.size());

//         // count the finished number
//         AtomicInteger finishedPatientCounter = new AtomicInteger(0);
//         BlockingQueue<String> idQueue = new LinkedBlockingQueue<>(patients);


//         int paraCount = job.getThreads();
//         ExecutorService scheduler = generateNewThreadPool(paraCount);
//         try{
//             this.bufferedWriter = new BufferedWriter(new FileWriter(pathname,true));
//             this.bufferedWriter.write("Cores: "+paraCount);
//             this.bufferedWriter.newLine();
//             this.bufferedWriter.flush();
//             InfluxDB influxDB = generateIdbClient(false);
//             String command = "create database " + job.getDbName();
//             influxDB.query(new Query(command));
//             influxDB.close();
//         }catch (IOException e){
//             e.printStackTrace();
//             return;
//         }

//         LocalDateTime start_Time = LocalDateTime.now();
//         Runnable queryTask = () -> {
//             String pid;
//             InfluxDB influxDB = generateIdbClient(false);
//             while ((pid=idQueue.poll())!=null){
//                 try{
//                     // generate query
// //                    QueryResult res1 = influxDB.query(new Query(String.format("select first(\"max_I1_1\") from \"%s\" where arType='ar'", pid),"aggdata"));
// //                    QueryResult res2 = influxDB.query(new Query(String.format("select last(\"max_I1_1\") from \"%s\" where arType='ar'", pid),"aggdata"));

//                     String i11 = job.getFromDb().equals("data")?"I1_1":"max_I1_1";
//                     QueryResult res1 = influxDB.query(new Query(String.format("select first(\"%s\") from \"%s\" where arType='ar'",i11, pid),job.getFromDb()));
//                     QueryResult res2 = influxDB.query(new Query(String.format("select last(\"I1_1\") from \"%s\" where arType='ar'", pid),"data"));
//                     String startTime = res1.getResults().get(0).getSeries().get(0).getValues().get(0).get(0).toString();
//                     DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//                     String endTime = res2.getResults().get(0).getSeries().get(0).getValues().get(0).get(0).toString();
// //                    String endTime = LocalDateTime.parse(startTime,df).plusHours(7).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
// //                    System.out.println(startTime);
// //                    System.out.println(endTime);

// //                    // to do the next 7h.
// //                    for(int i=0;i<1;i++){
// //                        startTime = endTime;
// //                        endTime = LocalDateTime.parse(startTime,df).plusHours(7).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
// //                    }

//                     //skip first 14 hours
//                     startTime = LocalDateTime.parse(startTime,df).plusHours(14).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";


//                     // generate the batch
//                     BatchPoints records = BatchPoints.database(job.getDbName()).tag("arType","ar").build();
//                    String endTime = res2.getResults().get(0).getSeries().get(0).getValues().get(0).get(0).toString();
                    String endTime = LocalDateTime.parse(startTime,df).plusHours(24).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
//                    System.out.println(startTime);
//                    System.out.println(endTime);

//                    // to do the nth 24h.
                    for(int i=0;i<job.getNday()-1;i++){
                        startTime = endTime;
                        endTime = LocalDateTime.parse(startTime,df).plusHours(24).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
                    }

                    //skip first 14 hours
//                    startTime = LocalDateTime.parse(startTime,df).plusHours(14).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";


                    // generate the batchs
                    BatchPoints records_60m = BatchPoints.database(DBNAME_1H+job.getVersion()).tag("arType","ar").build();

                    // generate part of the query
                    StringBuilder sb = new StringBuilder();
                    sb.append("select ");
                    List<String> cols = getColumns();
                    for(String x: cols){
                        sb.append(String.format("\"%s\", ",x));
                    }
                    String former = sb.toString();
                    former = former.substring(0,former.length()-2);
                    String formerQuery = former+String.format(" from \"%s\" where arType='ar' AND ",pid);

                    // run query hour by hour
                    int count = 0;
                    String subStartTime = startTime;
                    String subEndTime;

                    // while (LocalDateTime.parse(subStartTime,df).isBefore(LocalDateTime.parse(endTime,df)) || subStartTime.equals(endTime)){
                    while (LocalDateTime.parse(subStartTime,df).isBefore(LocalDateTime.parse(endTime,df))){

                        StringBuilder oneHoursb = new StringBuilder();
                        oneHoursb.append(formerQuery);
                        subStartTime = LocalDateTime.parse(startTime,df).plusHours(count).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
                        subEndTime = LocalDateTime.parse(startTime,df).plusHours(count+1).withMinute(0).withSecond(0).withNano(0).toString()+":00"+"Z";
                        oneHoursb.append(String.format("time>='%s' AND time<'%s'",subStartTime,subEndTime));
                        String query = oneHoursb.toString();
//                        System.out.println(query);

                        QueryResult rs = influxDB.query(new Query(query,"data"));
                        count++;

//                        System.out.println(queries.get(count));
//
//                      calculate 8 features
                        if(rs==null || rs.getResults().get(0) == null || rs.getResults().get(0).getSeries() == null || rs.getResults().get(0).getSeries().isEmpty() || rs.getResults().get(0).getSeries().get(0) == null){
                            continue;
                        }
// <<<<<<< HEAD
                    //     HashMap<String,Object> map  = new HashMap<>(cols.size()*8,1.0f);
                    //     getSortedFeatures(map,rs);
                    //     getSumFeatures(map,rs);
                    //     Point record = Point.measurement(pid).time(LocalDateTime.parse(subStartTime,df).toInstant(ZoneOffset.UTC).toEpochMilli(),TimeUnit.MILLISECONDS).fields(map).build();
                    //     records.point(record);
                    //     count++;
                    //     influxDB.flush();
                    // }

                    // influxDB.write(records);
// =======
                        // do 60m agg
//                        HashMap<String,Object> map  = new HashMap<>(cols.size()*8,1.0f);
//                        getSortedFeatures(map,rs);
//                        getSumFeatures(map,rs);
//                        Point record = Point.measurement(pid).time(LocalDateTime.parse(subStartTime,df).toInstant(ZoneOffset.UTC).toEpochMilli(),TimeUnit.MILLISECONDS).fields(map).build();
//                        records_60m.point(record);
//                        System.out.println("60");
                        // do 1m agg
                        getAllFeaturesAggregation(subStartTime,rs,DBNAME_1M+job.getVersion(), 1,df,pid,influxDB,"ar");
//                        System.out.println("1");
                        // do 30m agg
//                        getAllFeaturesAggregation(subStartTime,rs,DBNAME_30M+job.getVersion(), 30,df,pid,influxDB,"ar");
//                        System.out.println("30");
                        // do 15m agg
//                        getAllFeaturesAggregation(subStartTime,rs,DBNAME_15M+job.getVersion(), 15,df,pid,influxDB,"ar");
//                        System.out.println("15");
                        // do 10m agg
//                        getAllFeaturesAggregation(subStartTime,rs,DBNAME_10M+job.getVersion(), 10,df,pid,influxDB,"ar");
//                        System.out.println("10");
                        // do 5m agg
//                        getAllFeaturesAggregation(subStartTime,rs,DBNAME_5M+job.getVersion(), 5,df,pid,influxDB,"ar");
//                        System.out.println("5");
                    }

//                    influxDB.write(records_60m);



                    // one patient finished
                    this.bufferedWriter.write("Success: "+pid);
                    this.bufferedWriter.newLine();
                    this.bufferedWriter.flush();
                    finishedPatientCounter.getAndIncrement();
                    aggregationDao.updatePatientFinishedNum(job.getId(),finishedPatientCounter.get());

                }catch (Exception e){
                    logger.info(pid);
                    recordError(pid,e);
                    finishedPatientCounter.getAndIncrement();
                    aggregationDao.updatePatientFinishedNum(job.getId(),finishedPatientCounter.get());
                    e.printStackTrace();
                }
            }
            influxDB.close();
        };

        for (int i = 0; i < paraCount; ++i) {
            scheduler.submit(queryTask);
        }
        scheduler.shutdown();
        try {
            scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error(Util.stackTraceErrorToString(e));
        }
        finally {
            try{
                LocalDateTime end_Time = LocalDateTime.now();
                this.bufferedWriter.write(String.valueOf(Duration.between(start_Time,end_Time)).replace("PT","Run Time: "));
                this.bufferedWriter.newLine();
                this.bufferedWriter.flush();
                this.bufferedWriter.close();
                System.out.println("Job finished");
                aggregationDao.updateStatus(job.getId(),"Success");
                aggregationDao.updateTimeCost(job.getId(),String.valueOf(Duration.between(start_Time,end_Time)));
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }



    private String getAggTime(Integer aggregateTime) {
        int h = 3600;
        int m = 60;
        if(aggregateTime%h==0){
            return aggregateTime/h+"h";
        }
        if(aggregateTime%m==0){
            return aggregateTime/m+"m";
        }
        return aggregateTime+"s";
    }

    public List<String> getColumns(){
        List<String> columns = new ArrayList<>();
        int[][] x = {{1,1},{2,2},{3,3},{4,42},{43,81},{82,120},{121,159},{160,171},{172,176},{177,191},{192,230},{231,269},{270,270}};
        int[][] y = {{1,3},{1,24},{1,1},{1,40},{1,5},{1,1},{1,97},{1,1},{1,34},{1,1},{1,1},{1,5},{1,1}};
        for(int k=0;k<x.length;k++){
            for(int i=x[k][0];i<=x[k][1];i++){
                for(int j=y[k][0];j<=y[k][1];j++){
                    columns.add("I"+i+"_"+j);
                }
            }
        }
        return columns;
    }

    private List<String> getSelection(List<String> columns,AggregationDatabaseWithBLOBs job){
        System.out.println("getSelection!");
    	List<String> res= new ArrayList<>();
        StringBuilder onepart = new StringBuilder();


        // for(int count=0;count<15;count++){
        //     for(int j=count*380;j<(count+1)*380;j++){


        int parts = job.getParts();
        int onePartLength = columns.size()/parts;
        for(int count=0;count<parts;count++){
            for(int j=count*onePartLength;j<(count+1)*onePartLength;j++){

                //onepart.append(String.format("max(\"%s\") as max_%s , min(\"%s\") as min_%s,", "max_"+columns.get(j), columns.get(j), "min_"+columns.get(j),columns.get(j)));
                onepart.append(getAggregations(job,columns.get(j)));
            }
            res.add(onepart.substring(0,onepart.length()-2));
            onepart = new StringBuilder();
        }


        // for(int j=15*380;j<columns.size();j++){
        for(int j=parts*onePartLength;j<columns.size();j++){

            //onepart.append(String.format("max(\"%s\") as max_%s , min(\"%s\") as min_%s,", "max_"+columns.get(j), columns.get(j), "min_"+columns.get(j),columns.get(j)));
            onepart.append(getAggregations(job,columns.get(j)));
        }
        res.add(onepart.substring(0,onepart.length()-2));
        return res;
    }

    private int determineParaNumber() {
        int paraCount = (int) Math.round(loadFactor* InfluxappConfig.AvailableCores);
        return paraCount > 0 ? paraCount : 1;
    }

    private void recordError(String pid,Exception ex){
        try{
            this.bufferedWriter.write("Failed PID: "+pid +ex.getMessage());
            this.bufferedWriter.newLine();
            this.bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private ExecutorService generateNewThreadPool(int i) {
        return Executors.newFixedThreadPool(i);
    }

    public String databaseNavigator(String query){
        String dbname="";

        return dbname;
    }

    public List<AggregationDb> selectAllAvailableDBs() {
        return aggregationDao.selectAllAvailableDBs();
    }
    
    public List<AggregationDatabase> selectAllUsefulDBs(Integer period, Integer origin, Integer duration, String max, String min, String mean, String median,
    		String std, String fq, String tq, String sum) {
        return aggregationDao.selectAllUsefulDBs(period, origin, duration, max, min, mean, median, std, fq, tq, sum);
    }


//    public boolean completeJobAndInsert(AggregationDatabaseWithBLOBs database) {
////        String dbname = database.getDbName()+"_V"+database.getVersion();
////        List<AggregationDatabase> databaseList = aggregationDao.selectByname(dbname);
////        if(!databaseList.isEmpty()){
////            AggregationDatabaseWithBLOBs db = new AggregationDatabaseWithBLOBs();
////            db.setId(databaseList.get(0).getId());
////            db.setDbName(dbname);
////            if(database.getMean()){
////                db.setMean(true);
////            }
////            if(database.getSum()){
////                db.setSum(true);
////            }
////            if(database.getMax()){
////                db.setMax(true);
////            }
////            if(database.getMedian()){
////                db.setMedian(true);
////            }
////            if(database.getQ1()){
////                db.setQ1(true);
////            }
////            if(database.getQ3()){
////                db.setQ3(true);
////            }
////            if(database.getSd()){
////                db.setSd(true);
////            }
////            if(database.getMin()){
////                db.setMin(true);
////            }
////            db.setFinished(0);
////            db.setCreateTime(LocalDateTime.now());
////            db.setThreads(database.getThreads());
////            db.setParts(database.getParts());
////            return aggregationDao.updateAggretaionMethods(db) !=0;
////        }else {
//            database.setVersion(versionDao.getLatestVersion());
//            database.setStatus("processing");
//            database.setDbName(database.getDbName()+"_V"+database.getVersion());
//            database.setCreateTime(LocalDateTime.now(ZoneId.of("America/New_York")));
//            return aggregationDao.setNewDB(database) != 0;
////        }
//
//
//    }


    public boolean insertNewDB(AggregationDb job){
        job.setVersion(versionDao.getLatestVersion());
        job.setStatus("processing");
        job.setCreateTime(LocalDateTime.now(ZoneId.of("America/New_York")));
        return aggregationDao.insertNewDB(job) != 0;
    }

    public List<AggregationDb> selectAllOnGoing() {
        return aggregationDao.selectOngoing();
    }

//    public boolean addOneAggregationJob(Integer jobId) {
//        AggregationDatabaseWithBLOBs databaseWithBLOBs = aggregationDao.selectByPrimaryKey(jobId);
//        try {
//            System.out.println("successfully added to the job Queue!");
//            return this.jobQueue.add(databaseWithBLOBs);
//        } catch (Exception e) {
//            logger.error("Add job failed.", e);
//            return false;
//        }
//    }

    public boolean addOneAggregationJob(Integer jobId) {
        AggregationDb aggregationDb = aggregationDao.selectByPrimaryKey(jobId);
        try {
            System.out.println("successfully added to the job Queue!");
            return this.jobQueue.add(aggregationDb);
        } catch (Exception e) {
            logger.error("Add job failed.", e);
            return false;
        }
    }

    public void checkIntegrity(AggregationDatabaseWithBLOBs job){
        String path = "/tsdb/output/Integrity/"+job.getDbName()+".txt";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
            List<String> pids = importedFileDao.selectAllImportedPidOnMachine("realpsc");
            InfluxDB influxDB = generateIdbClient(false);
            int count = 0;
            if(job.getMean()){
                count++;
            }
            if(job.getSum()){
                count++;
            }
            if(job.getMax()){
                count++;
            }
            if(job.getMedian()){
                count++;
            }
            if(job.getQ1()){
                count++;
            }
            if(job.getQ3()){
                count++;
            }
            if(job.getSd()){
                count++;
            }
            if(job.getMin()){
                count++;
            }
            for(int i=0;i<pids.size();i++){
                String query = String.format("show field keys from \"%s\"",pids.get(i));
                QueryResult rs = influxDB.query(new Query(query,"data"));
                QueryResult rs2 = influxDB.query(new Query(query,job.getDbName()));
                int keys = rs.getResults().get(0).getSeries().get(0).getValues().size();
                int keys2 = rs2.getResults().get(0).getSeries().get(0).getValues().size();
                if((keys-1)*count != keys2 && keys2!= 6035*count && keys2!=6037*count){
                    writer.write(pids.get(i)+":"+keys+","+keys2);
                    writer.newLine();
                    writer.flush();
                }
            }
            influxDB.close();
            writer.write("finished");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getAggregations(AggregationDatabaseWithBLOBs job,String col){
        StringBuilder builder = new StringBuilder();
        if(job.getFromDb().equals("data")){
            if(job.getMax()){
                builder.append(String.format("max(\"%s\") as max_%s, ",col,col));
            }
            if(job.getMin()){
                builder.append(String.format("min(\"%s\") as min_%s, ",col,col));
            }
            if(job.getMedian()){
                builder.append(String.format("median(\"%s\") as median_%s, ",col,col));
            }
            if(job.getQ1()){
                builder.append(String.format("percentile(\"%s\",25) as p25_%s, ",col,col));
            }
            if(job.getQ3()){
                builder.append(String.format("percentile(\"%s\",75) as p75_%s, ",col,col));
            }
            if(job.getSd()){
                builder.append(String.format("stddev(\"%s\") as std_%s, ",col,col));
            }
            if(job.getSum()){
                builder.append(String.format("sum(\"%s\") as sum_%s, ",col,col));
            }
            if(job.getMean()){
                builder.append(String.format("mean(\"%s\") as mean_%s, ",col,col));
            }
        }else {
            if(job.getMax()){
                builder.append(String.format("max(\"%s\") as max_%s, ","max_"+col,col));
            }
            if(job.getMin()){
                builder.append(String.format("min(\"%s\") as min_%s, ","min_"+col,col));
            }
            if(job.getMedian()){
                builder.append(String.format("median(\"%s\") as median_%s, ","median_"+col,col));
            }
            if(job.getQ1()){
                builder.append(String.format("percentile(\"%s\",25) as p25_%s, ","p25_"+col,col));
            }
            if(job.getQ3()){
                builder.append(String.format("percentile(\"%s\",75) as p75_%s, ","p75_"+col,col));
            }
            if(job.getSd()){
                builder.append(String.format("stddev(\"%s\") as std_%s, ","mean_"+col,col));
            }
            if(job.getSum()){
                builder.append(String.format("sum(\"%s\") as sum_%s, ",col,col));
            }
            if(job.getMean()){
                builder.append(String.format("mean(\"%s\") as mean_%s, ",col,col));
            }
        }
        String finalq = builder.toString();
        return finalq;
    }


    public void getSortedFeatures(HashMap<String,Object> map, QueryResult res){
        List<String> colums = res.getResults().get(0).getSeries().get(0).getColumns();
        for(int i=1;i<colums.size();i++){
            //get the current column
            List<Double> arr = getOneColumn(res,i);
            if(arr.isEmpty()){
                continue;
            }
            Collections.sort(arr);
            int size = arr.size();
            double median = (arr.get((size-1)/2) + arr.get(size/2))/2;
            double max = arr.get(size-1);
            double min = arr.get(0);
            double p25 = arr.get(Math.max(0,(int)(0.25*size)-1));
            double p75 = arr.get(Math.max(0,(int)(0.75*size)-1));
            map.put("median_"+colums.get(i),median);
            map.put("max_"+colums.get(i),max);
            map.put("min_"+colums.get(i),min);
            map.put("p25_"+colums.get(i),p25);
            map.put("p75_"+colums.get(i),p75);
        }
    }

    public void getSumFeatures(HashMap<String,Object> map, QueryResult res){
        List<String> colums = res.getResults().get(0).getSeries().get(0).getColumns();
        for(int i=1;i<colums.size();i++){
            List<Double> arr = getOneColumn(res,i);
            if(arr.isEmpty()){
                continue;
            }
            double sum = 0;
            int size = arr.size();
            double var = 0;
            for(int j=0;j<size;j++){
                sum+=arr.get(j);
            }

            double mean = sum/size;
            for(int k=0; k<arr.size();k++){
                var += Math.pow(arr.get(k) - mean,2);
            }

            var = var/size;
            var = Math.sqrt(var);
            map.put("mean_"+colums.get(i),mean);
            map.put("sum_"+colums.get(i),sum);
            map.put("std_"+colums.get(i),var);
        }
    }


    private void getAllFeaturesAggregation(String subStartTime, QueryResult res, String dbname, int minutes,DateTimeFormatter df,String pid,InfluxDB influxDB, String arType){
        BatchPoints batch = BatchPoints.database(dbname).tag("arType","ar").build();
        List<String> colums = res.getResults().get(0).getSeries().get(0).getColumns();
        HashMap<String,HashMap<String,Object>> maps = new HashMap<>();
        for(int i=0;i<(int)(60/minutes);i++){
            maps.put(LocalDateTime.parse(subStartTime,df).plusMinutes(i*minutes).toString()+":00Z",new HashMap<>());
        }
        for(int i=1;i<colums.size();i++){
            HashMap<String,List<Double>> tempResults = getOneColumnwithTime(res,i,subStartTime,minutes,df);
            for(Map.Entry<String,List<Double>> subRes: tempResults.entrySet()){
                HashMap<String,Object> currentMap = maps.get(subRes.getKey());
                List<Double> arr = subRes.getValue();
                if(arr.isEmpty()){
                    continue;
                }
                double sum = 0;
                int size = arr.size();
                double var = 0;
                for(int j=0;j<size;j++){
                    sum+=arr.get(j);
                }
                sum = Double.parseDouble(DIGIT.format(sum));
                double mean = Double.parseDouble(DIGIT.format(sum/size));
                for(int k=0; k<arr.size();k++){
                    var += Math.pow(arr.get(k) - mean,2);
                }

                var = var/size;
                var = Double.parseDouble(DIGIT.format(Math.sqrt(var)));

                Collections.sort(arr);
                double median = Double.parseDouble(DIGIT.format((arr.get((size-1)/2) + arr.get(size/2))/2));
                double max = Double.parseDouble(DIGIT.format(arr.get(size-1)));
                double min = Double.parseDouble(DIGIT.format(arr.get(0)));
                double p25 = Double.parseDouble(DIGIT.format(arr.get(Math.max(0,(int)(0.25*size)-1))));
                double p75 = Double.parseDouble(DIGIT.format(arr.get(Math.max(0,(int)(0.75*size)-1))));

                currentMap.put("median_"+colums.get(i),median);
                currentMap.put("max_"+colums.get(i),max);
                currentMap.put("min_"+colums.get(i),min);
                currentMap.put("p25_"+colums.get(i),p25);
                currentMap.put("p75_"+colums.get(i),p75);
                currentMap.put("mean_"+colums.get(i),mean);
                currentMap.put("sum_"+colums.get(i),sum);
                currentMap.put("std_"+colums.get(i),var);

            }
        }
        try {
            int batchCount =0;
            for(Map.Entry<String,HashMap<String,Object>> part : maps.entrySet()){
                if(part.getValue().keySet().isEmpty()){
                    continue;
                }

                Point record = Point.measurement(pid).time(LocalDateTime.parse(part.getKey(),df).toInstant(ZoneOffset.UTC).toEpochMilli(),TimeUnit.MILLISECONDS).tag("arType",arType).fields(part.getValue()).build();
                batch.point(record);
                batchCount++;

                if(batchCount>=MAXBATCH){
                    long start = System.currentTimeMillis();
                    influxDB.write(batch);
                    influxDB.flush();
                    long end = System.currentTimeMillis();
                    batchCount=0;
                    batch = BatchPoints.database(dbname).tag("arType","ar").build();
                    if(end-start>softTimeOut){
                        System.out.println("Warning time out");
                        TimeUnit.SECONDS.sleep(timeoutSleep);
                    }
                }

            }
            influxDB.write(batch);
            influxDB.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private List<Double> getOneColumn(QueryResult res, int col) {
        int n = res.getResults().get(0).getSeries().get(0).getValues().size();
        List<Double> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res.getResults().get(0).getSeries().get(0).getValues().get(i).get(col)!=null){
                arr.add((double) res.getResults().get(0).getSeries().get(0).getValues().get(i).get(col));
            }
        }
        return arr;
    }


    private HashMap<String,List<Double>> getOneColumnwithTime(QueryResult res, int col, String subStratTime, int minutes,DateTimeFormatter df){
        LocalDateTime currentTime = LocalDateTime.parse(subStratTime,df);
        HashMap<String,List<Double>> result = new HashMap<>();
        int n = res.getResults().get(0).getSeries().get(0).getValues().size();
        int row =0;
        while (currentTime.isBefore(LocalDateTime.parse(subStratTime,df).plusHours(1))){
            List<Double> arr = new ArrayList<>();
            while (row<n){
                if(res.getResults().get(0).getSeries().get(0).getValues().get(row).get(col) == null){
                    row++;
                    continue;
                }
                if(LocalDateTime.parse(res.getResults().get(0).getSeries().get(0).getValues().get(row).get(0).toString(),df).isBefore(currentTime.plusMinutes(minutes))){
                    arr.add((double)res.getResults().get(0).getSeries().get(0).getValues().get(row).get(col));
                    row++;
                }else {
                    break;
                }
            }
            result.put(currentTime.toString()+":00Z",new ArrayList<>(arr));
            currentTime = currentTime.plusMinutes(minutes);
        }
        return result;
    }


    private InfluxDB generateIdbClient(Boolean needGzip) {
        // Disable GZip to save CPU
        InfluxDB idb = InfluxDBFactory.connect(InfluxappConfig.IFX_ADDR, InfluxappConfig.IFX_USERNAME,
                InfluxappConfig.IFX_PASSWD, new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(1, TimeUnit.HOURS).writeTimeout(1, TimeUnit.HOURS));
        if (needGzip) {
            idb.enableGzip();
        } else {
            idb.disableGzip();
        }
        BatchOptions bo = BatchOptions.DEFAULTS.consistency(InfluxDB.ConsistencyLevel.ALL)
                // Flush every 2000 Points, at least every 100ms, buffer for failed oper is 2200
                .actions(2000).flushDuration(500).bufferLimit(10000).jitterDuration(200)
                .exceptionHandler((p, t) -> logger.warn("Write point failed", t));
        idb.enableBatch(bo);

        return idb;
    }


	public int updateComment(AggregationDb aggregationdb) {
		return aggregationDao.updateComment(aggregationdb);
		
	}

//    public String getDbName(AggregationDatabaseWithBLOBs database) {
//        String dbname = database.getDbName()+"_V"+versionDao.getLatestVersion();
//        return dbname;
//    }
//
//    public int getJobId(String dbname) {
//        return aggregationDao.selectJobIdByName(dbname);
//    }
}

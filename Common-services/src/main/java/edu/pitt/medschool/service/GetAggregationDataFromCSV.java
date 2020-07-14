package edu.pitt.medschool.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.lang.Integer;
import java.io.*;


public class GetAggregationDataFromCSV
{	
    public static List<String> init(String path) {

        List<String> rows = readRowsFromCSV(path);
        return rows;
    }

    public static List<String> readRowsFromCSV(String fileName) {
        List<String> list = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = new String();
            //int lineCount = 0;
            line = br.readLine(); //wait for reading the column names
    //        System.out.println(line);
            // loop until all lines are read
            line = br.readLine();
            while (line != null) {
            	// read next line before looping
                // if end of file reached, line would be null
                list.add(line);
				line = br.readLine();
                // adding book into ArrayList

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return list;
    }
    
    public static class result
    {
        public int[] time; 
        public float[] value_30; 
        public float[] value_60;
        public float[] value_120;  
     };
    
    static result Result = new result();
    
    
    public static float[] agg_30s_mean(float[] data,int max)
    {
    	float[] aggregated_arr = new float[max];
    	
    	//this var should be set to 0 at each aggregation time point
    	float temp_sum = 0;
    	//this var should be set to temp_sum at each agg point
    	float temp_sum_n = 0;
    	
    	int x =0;
    	
    	for(int i = 0; i < max;i++)
    	{
    	   temp_sum += data[i];
    	   x = i % 30;
    	   if(i != 0 && x == 0)
    	   {
    		  temp_sum_n = temp_sum;
    		  aggregated_arr[i]=temp_sum/30;
    		  temp_sum = 0;
    	   }
    	   else
    	   {
    		   aggregated_arr[i]=temp_sum_n ;
    	   }
    		
    	}
    	
    	return aggregated_arr;

    }
    
    public static float[] agg_60s_mean(float[] data,int max)
    {
    	float[] aggregated_arr = new float[max];
    	
    	//this var should be set to 0 at each aggregation time point
    	float temp_sum = 0;
    	//this var should be set to temp_sum at each agg point
    	float temp_sum_n = 2;
    	
    	int x =0;
    	
    	for(int i = 0; i < max;i++)
    	{
    	   temp_sum += data[i];
    	   x = i % 60;
    	   if(i != 0 && x == 0)
    	   {
    		  temp_sum_n = temp_sum + 2;
    		  aggregated_arr[i]=temp_sum/60 + 2;
    		  temp_sum = 0;
    	   }
    	   else
    	   {
    		   aggregated_arr[i]=temp_sum_n ;
    	   }
    		
    	}
    	
    	return aggregated_arr;

    }
    
    public static float[] agg_120s_mean(float[] data,int max)
    {
    	float[] aggregated_arr = new float[max];
    	
    	//this var should be set to 0 at each aggregation time point
    	float temp_sum = 0;
    	//this var should be set to temp_sum at each agg point
    	float temp_sum_n = 4;
    	
    	int x =0;
    	
    	for(int i = 0; i < max;i++)
    	{
    	   temp_sum += data[i];
    	   x = i % 120;
    	   if(i != 0 && x == 0)
    	   {
    		  temp_sum_n = temp_sum + 4;
    		  aggregated_arr[i]=temp_sum/120 + 4;
    		  temp_sum = 0;
    	   }
    	   else
    	   {
    		   aggregated_arr[i]=temp_sum_n ;
    	   }
    		
    	}
    	
    	return aggregated_arr;

    }
    
    public static result main() throws FileNotFoundException {
        List<String> result = GetAggregationDataFromCSV.init("/Users/haohanzhong/Downloads/PUH-2013-153_01noar.csv");
        int length = result.size() + 1;
        //array holds time values
        int[] time = new int[length];
        //array holds feature values
        float[] value = new float[length];
        float[] value_30 = new float[length];
        float[] value_60 = new float[length];
        float[] value_120 = new float[length];

         
        
        String[][] two_D_table = new String[1515][6040];
        String[] array = result.toArray(new String[0]);
      
        for(int i = 0 ; i < 1514; i++)
        {
        	 two_D_table[i] = array[i].split(",",6039);
        }
       
      
        for(int i =7;i <1514;i++)
        {
        	time[i] = Integer.parseInt(two_D_table[i][1]);
        }
        
        for(int i =7;i <1514;i++)
        {
        	value[i] = Float.parseFloat(two_D_table[i][5]);
        }
        
        System.out.println(agg_30s_mean(value,length)); 
        
        Result.time = time;
        Result.value_30 = agg_30s_mean(value,length);
        Result.value_60 = agg_60s_mean(value,length);
        Result.value_120 = agg_120s_mean(value,length);
        
        
        
        return Result;
    }
	
	
	
}
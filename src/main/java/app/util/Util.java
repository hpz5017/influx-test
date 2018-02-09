/**
 *
 */
package app.util;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;

import app.bean.FileBean;

/**
 * @author Isolachine
 */
public class Util {

    /**
     * Convert a DoB String (e.g. 04/27/1995) to UNIX timestamp
     *
     * @param dateOfBirth
     *            DOB String
     * @return long UNIX Timestamp
     * @throws ParseException
     *             Shouldn't happen
     */
    public static long dateToTimestamp(String dateOfBirth) throws ParseException {
        return dateTimeFormatToTimestamp(dateOfBirth, "mm/dd/yyyy");
    }

    /**
     * Convert some string to a UNIX timestamp
     *
     * @param dateTime
     *            String
     * @param format
     *            String format
     * @return long UNIX Timestamp
     * @throws ParseException
     *             Wrong format
     */
    public static long dateTimeFormatToTimestamp(String dateTime, String format) throws ParseException {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(timeZone);
        return formatter.parse(dateTime).getTime();
    }

    /**
     * Convert UNIX Timestamp to UTC Time string (US format)
     *
     * @param unixTime
     *            UNIX Timestamp
     * @return String Formatted DateTime
     */
    public static String timestampToUTCDate(long unixTime) {
        return timestampToUTCDateTimeFormat(unixTime, "mm/dd/yyyy");
    }

    /**
     * Convert UNIX Timestamp to UTC Time (Any format)
     *
     * @param unixTime
     *            UNIX Timestamp
     * @param format
     *            String UTC
     * @return
     */
    public static String timestampToUTCDateTimeFormat(long unixTime, String format) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(timeZone);
        return formatter.format(new Date(unixTime));
    }

    /**
     * Convert serial# time to a specific timestamp
     *
     * @param serial
     *            String Serial number
     * @return Apache POI defined timestamp
     */
    public static long serialTimeToLongDate(String serial) {
        return DateUtil.getJavaDate(Double.valueOf(serial)).getTime();
    }

    /**
     * Get all CSV files under a directory
     *
     * @param dir
     *            String directory path
     * @return String Full file path
     */
    public static String[] getAllCsvFileInDirectory(String dir) {
        return getAllSpecificFileInDirectory(dir, "csv");
    }

    /**
     * Get all specific files under a directory
     *
     * @param dir
     *            String directory path
     * @param type
     *            String file extension
     * @return String Full file path
     */
    public static String[] getAllSpecificFileInDirectory(String dir, String type) {
        File folder = new File(dir);
        if (folder.isFile()) {
            if (dir.toLowerCase().endsWith("." + type))
                return new String[] { dir };
            else
                return new String[0];
        }

        FilenameFilter txtFileFilter = (dirs, name) -> {
            // Filter hidden or not wanted file
            if (!name.startsWith(".") && name.toLowerCase().endsWith("." + type))
                return true;
            return false;
        };
        File[] files = folder.listFiles(txtFileFilter);

        assert files != null;
        if (files.length == 0)
            return new String[0];

        LinkedList<String> file_list = new LinkedList<>();
        for (File file : files) {
            if (file.isFile())
                file_list.add(file.getAbsolutePath());
        }

        return file_list.toArray(new String[file_list.size()]);
    }

    public static int timestampToAge(long birthDate) {
        LocalDate dob = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(dob, now).getYears();
    }


    public static List<FileBean> filesInFolder(String directory) {
        File folder = new File(directory);

        if (!directory.endsWith("/")) {
            directory += "/";
        }

        File[] listOfFiles = folder.listFiles();
        List<FileBean> fileBeans = new ArrayList<>();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    FileBean fileBean = new FileBean();
                    fileBean.setName(listOfFiles[i].getName());
                    fileBean.setDirectory(directory);
                    long length = FileUtils.sizeOf(listOfFiles[i]);
                    fileBean.setBytes(length);
                    fileBean.setSize(FileUtils.byteCountToDisplaySize(length));
                    fileBeans.add(fileBean);
                }
            }
        }
        return fileBeans;
    }

    public static void main(String[] args) throws ParseException {

        System.out.println(filesInFolder("/Users/Isolachine/tsdb/ar/"));

        System.out.println(dateToTimestamp("1/2/1934"));
        System.out.println(timestampToUTCDate(dateToTimestamp("1/1/1934")));
        System.out.println(dateTimeFormatToTimestamp("2017.10.28 15:00:17", "yyyy.MM.dd HH:mm:ss"));
        System.out.println(timestampToUTCDateTimeFormat(dateTimeFormatToTimestamp("2017.10.28 15:00:17", "yyyy.MM.dd HH:mm:ss"), "yyyy.MM.dd HH:mm:ss"));
        System.out.println(timestampToUTCDateTimeFormat(serialTimeToLongDate("43036.6402314815"), "yyyy-MM-dd HH:mm:ss"));

        String[] testF = getAllSpecificFileInDirectory("E:\\Grad@Pitt\\TS ProjectData", "csv");
        for (String a : testF) {
            System.out.println(a);
        }
    }
}

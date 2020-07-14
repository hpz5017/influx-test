package edu.pitt.medschool.controller.analysis;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
public class CsvReader {


    public static List<String> init(String path) {

        List<String> rows = readRowsFromCSV(path);
        return rows;
    }

    private static List<String> readRowsFromCSV(String fileName) {
        List<String> list = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = new String();
            //int lineCount = 0;
            line = br.readLine(); //wait for reading the column names
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
    
    public static void main(String[] args) {
        List<String> result = CsvReader.init("src/main/resources/public/csv/attributes.csv");
        System.out.printf("Length: %d \n", result.size());
        System.out.println(result.get(1));
    }
}

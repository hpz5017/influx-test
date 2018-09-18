package edu.pitt.medschool;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import edu.pitt.medschool.framework.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.pitt.medschool.framework.util.TimeUtil;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        TimeZone.setDefault(TimeUtil.nycTimeZone);
        logger.warn("BrainFlux start time: " + new Date());

        logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        logger.info("NonOptionArgs: {}", args.getNonOptionArgs());
        logger.info("OptionNames: {}", args.getOptionNames());

        for (String name : args.getOptionNames()) {
            logger.info("arg->" + name + "=" + args.getOptionValues(name));
        }

        if (!args.containsOption("machine")) {
            logger.error("Using default machine name: Anyone!!!");
        }

        // For storing zip files
        String path = "archive";
        File outputDir = new File(path);

        if (!outputDir.exists()) {
            try {
                if (!outputDir.mkdirs()) {
                    throw new RuntimeException("Failed to create output folder.");
                }
            } catch (SecurityException se) {
                logger.error(Util.stackTraceErrorToString(se));
            }
        }

    }
}

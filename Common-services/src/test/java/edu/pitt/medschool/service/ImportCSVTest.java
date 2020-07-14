package edu.pitt.medschool.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportCSVTest {
    @Autowired
    ImportCsvService ics;

    @Value("${machine}")
    private String uuid;

    @Test
    public void basicTest() throws Exception {
        assertEquals(ics.GetUUID(), uuid);
    }

}
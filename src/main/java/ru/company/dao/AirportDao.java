package ru.company.dao;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportDao {
    private String csvFile;

    public List<List<String>> readAll () {
        List<List<String>> airports = new ArrayList<>();
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            CSVReader reader = new CSVReader(new FileReader(new File(classLoader.getResource(csvFile).getFile())));
            String[] line;
            while ((line = reader.readNext()) != null) {
                List<String> airport = new ArrayList<>();
                for (String s : line) {
                    airport.add(s);
                }
                airports.add(airport);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return airports;
    }


    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }
}

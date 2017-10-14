package ru.company.service;

import ru.company.entity.Airport;

import java.io.*;
import java.util.*;

/**
 * Created by user on 13.10.2017.
 */
public class AirportService {
    List<Airport> list;

    public AirportService(){
        if (list == null) {
            list = new ArrayList<>();
            ClassLoader classLoader = getClass().getClassLoader();
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(classLoader.getResource("airports.dat").getFile())))) {
                while (reader.ready()) {
                    String line = reader.readLine().replaceAll("\"", "");
                    String[] s = line.split(",");
                    list.add(new Airport(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11], s[12], s[13]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Airport> getListByParam(String s) {
        if(s == null || "".equals(s)){
            return list;
        }
        List<Airport> newList = new ArrayList<>();
        for(Airport airport : list){
            if(airport.getCountry().equals(s)){
                newList.add(airport);
            }
        }
        return newList;
    }

    public Set<String> getListParam(){
        Set<String> set = new TreeSet<>();
        for(Airport airport : list){
            set.add(airport.getCountry());
        }
        return set;
    }
}

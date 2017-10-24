package ru.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.company.dao.AirportDao;

import java.util.*;

public class AirportService {

    @Autowired
    private AirportDao airportDao;

    private List<List<String>> airports;

    private int columnNumber;

    public AirportService(){ }

    public AirportService(AirportDao airportDao) {
        this.airportDao = airportDao;
        updateFullList();
    }

    public void updateFullList () {
        this.airports = airportDao.readAll();
    }

    public List<String> getFilterParams() {
        return null;
    }

    public List<List<String>> filteredAirports(String filter) {
        return filteredAirports(columnNumber, filter);
    }


    public List<List<String>> filteredAirports(int column, String filter) {
        if (filter.length() < 1) {
            return this.airports;
        }
        List<List<String>> filtered = new ArrayList<>();
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).get(column).equals(filter)) {
                List<String> filteredairport = new ArrayList<>();
                for (String s : airports.get(i)) {
                    filteredairport.add(s);
                }
                filtered.add(filteredairport);
            }
        }
        return filtered;
    }


    public SortedSet<String> getFilterData() {
        // column=3 - номер колонки для страны
        return getFilterData(columnNumber);
    }

    public SortedSet<String> getFilterData(int column) {
        SortedSet<String> filterData = new TreeSet<>();
        for (int i = 0; i < airports.size(); i++) {
            for (String s : airports.get(i)) {
                filterData.add(airports.get(i).get(column));
            }
        }
        return filterData;
    }

    public AirportDao getAirportDao() {
        return airportDao;
    }

    public void setAirportDao(AirportDao airportDao) {
        this.airportDao = airportDao;
    }

    public List<List<String>> getAirports() {
        return airports;
    }

    public void setAirports(List<List<String>> airports) {
        this.airports = airports;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}

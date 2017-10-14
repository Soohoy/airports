package ru.company.entity;

public class Airport {
    String n;
    String nameAirport;
    String city;
    String country;
    String iata;
    String icao;
    String latitude;
    String longitude;
    String num;
    String tz;
    String dst;
    String tzName;
    String type;
    String source;

    public Airport(){}

    public Airport(String n, String nameAirport, String city, String country, String iata, String icao,
                   String latitude, String longitude, String num, String tz, String dst, String tzName,
                   String type, String source) {
        this.n = n;
        this.nameAirport = nameAirport;
        this.city = city;
        this.country = country;
        this.iata = iata;
        this.icao = icao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.num = num;
        this.tz = tz;
        this.dst = dst;
        this.tzName = tzName;
        this.type = type;
        this.source = source;
    }

    public String getN() {
        return n;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getIata() {
        return iata;
    }

    public String getIcao() {
        return icao;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getNum() {
        return num;
    }

    public String getTz() {
        return tz;
    }

    public String getDst() {
        return dst;
    }

    public String getTzName() {
        return tzName;
    }

    public String getType() {
        return type;
    }

    public String getSource() {
        return source;
    }
}

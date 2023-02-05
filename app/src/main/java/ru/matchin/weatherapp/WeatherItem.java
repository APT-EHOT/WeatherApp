package ru.matchin.weatherapp;

import java.util.List;

public class WeatherItem {
    public String dt_txt;
    public MainInfo main;
    public List<WeatherInfo> weather;

    class MainInfo {
        public Double temp;
        public Integer humidity;
    }

    class WeatherInfo {
        public String main;
    }
}

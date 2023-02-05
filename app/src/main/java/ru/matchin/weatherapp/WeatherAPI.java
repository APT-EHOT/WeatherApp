package ru.matchin.weatherapp;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    String BASE_URL = "https://api.openweathermap.org/";
    String CITY = "Moscow";
    String API_KEY = "e4bd1e894a7a54294374b554452de587";

    @GET("data/2.5/forecast")
    Observable<WeatherResponse> getWeather(
        @Query("q") String city,
        @Query("appid") String appId
    );
}

package com.example.weathershow.data.source.remote.api;

import com.example.weathershow.data.model.WeatherDetail;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IApiWeatherDetail {
    @GET("weather?")
    Single<WeatherDetail> getWeatherDetail(@Query("lat") float lat, @Query("lon") float lon, @Query("appid") String appid);
}

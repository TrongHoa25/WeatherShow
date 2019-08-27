package com.example.weathershow.data.source;

import com.example.weathershow.data.model.WeatherDetail;

import io.reactivex.Single;
import retrofit2.Call;

public interface IWeatherDetailSource {
    interface LocalDataSource{

    }

    interface RemoteDataSource{
        Single<WeatherDetail> getWeatherDetail(float lat, float lon, String appid);
    }

}

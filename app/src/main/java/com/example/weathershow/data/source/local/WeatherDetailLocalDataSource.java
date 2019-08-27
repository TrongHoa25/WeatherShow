package com.example.weathershow.data.source.local;

import com.example.weathershow.data.source.IWeatherDetailSource;

public class WeatherDetailLocalDataSource implements IWeatherDetailSource.LocalDataSource {
    private static WeatherDetailLocalDataSource instance;
    public static synchronized WeatherDetailLocalDataSource getInstance(){
        if(instance == null){
            instance = new WeatherDetailLocalDataSource();
        }
        return instance;
    }
}

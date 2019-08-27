package com.example.weathershow.data.repository;

import com.example.weathershow.data.model.WeatherDetail;
import com.example.weathershow.data.source.IWeatherDetailSource;

import io.reactivex.Single;
import retrofit2.Call;

public class WeatherDetailRepository implements IWeatherDetailSource.LocalDataSource, IWeatherDetailSource.RemoteDataSource {
    private static WeatherDetailRepository instance;

    private IWeatherDetailSource.RemoteDataSource remoteDataSource;
    private IWeatherDetailSource.LocalDataSource localDataSource;

    public WeatherDetailRepository(IWeatherDetailSource.RemoteDataSource remoteDataSource,
                                   IWeatherDetailSource.LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static synchronized WeatherDetailRepository getInstance(IWeatherDetailSource.LocalDataSource localDataSource,
                                                                   IWeatherDetailSource.RemoteDataSource remoteDataSource){
        if(instance == null){
            instance = new WeatherDetailRepository(remoteDataSource, localDataSource);
        }
        return instance;
    }

    @Override
    public Single<WeatherDetail> getWeatherDetail(float lat, float lon, String appid) {
        return remoteDataSource.getWeatherDetail(lat, lon, appid);
    }
}

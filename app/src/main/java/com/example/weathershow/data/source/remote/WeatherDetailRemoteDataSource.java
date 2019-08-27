package com.example.weathershow.data.source.remote;

import android.content.Context;

import com.example.weathershow.data.model.WeatherDetail;
import com.example.weathershow.data.source.IWeatherDetailSource;
import com.example.weathershow.data.source.remote.api.IApiWeatherDetail;
import com.example.weathershow.data.source.remote.service.AppServiceClients;

import io.reactivex.Single;
import retrofit2.Call;

public class WeatherDetailRemoteDataSource implements IWeatherDetailSource.RemoteDataSource {

    private static WeatherDetailRemoteDataSource instance;
    private IApiWeatherDetail iApiWeatherDetail;

    public WeatherDetailRemoteDataSource(IApiWeatherDetail iApiWeatherDetail) {
        this.iApiWeatherDetail = iApiWeatherDetail;
    }

    public static synchronized WeatherDetailRemoteDataSource getInstance(Context context){
        if (instance == null){
            instance = new WeatherDetailRemoteDataSource(AppServiceClients.getWeatherDetailInstance(context));
        }
        return instance;
    }

    @Override
    public Single<WeatherDetail> getWeatherDetail(float lat, float lon, String appid) {
        return iApiWeatherDetail.getWeatherDetail(lat, lon, appid);
    }

}

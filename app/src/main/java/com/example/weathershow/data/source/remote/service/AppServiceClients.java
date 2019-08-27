package com.example.weathershow.data.source.remote.service;

import android.content.Context;

import com.example.weathershow.data.source.remote.api.IApiWeatherDetail;
import com.example.weathershow.utils.AppConstants;

import static com.example.weathershow.data.source.remote.service.ServiceClient.createService;

public class AppServiceClients {
    protected static IApiWeatherDetail iApiWeatherDetail;

    public static IApiWeatherDetail getWeatherDetailInstance(Context context){
        if (iApiWeatherDetail == null){
            iApiWeatherDetail = createService(context, AppConstants.URL, IApiWeatherDetail.class);
        }
        return iApiWeatherDetail;
    }
}

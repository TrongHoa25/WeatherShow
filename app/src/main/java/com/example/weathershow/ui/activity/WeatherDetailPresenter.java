package com.example.weathershow.ui.activity;

import android.content.Context;

import com.example.weathershow.data.model.WeatherDetail;
import com.example.weathershow.data.repository.WeatherDetailRepository;
import com.example.weathershow.data.source.remote.response.WeatherDetailResponse;
import com.example.weathershow.utils.rx.BaseSchedulerProvider;

public class WeatherDetailPresenter implements WeatherDetailContract.Presenter {
    Context context;
    WeatherDetailContract.View view;
    WeatherDetailRepository weatherDetailRepository;
    public BaseSchedulerProvider baseSchedulerProvider;

    public void setView(WeatherDetailContract.View view) {
        this.view = view;
    }

    public WeatherDetailPresenter(Context context, WeatherDetailRepository weatherDetailRepository, BaseSchedulerProvider baseSchedulerProvider) {
        this.context = context;
        this.weatherDetailRepository = weatherDetailRepository;
        this.baseSchedulerProvider = baseSchedulerProvider;
    }

    @Override
    public void getWeatherDetail(float lat, float lon, String appid) {
        weatherDetailRepository.getWeatherDetail(lat, lon, appid)
                .subscribeOn(baseSchedulerProvider.io())
                .observeOn(baseSchedulerProvider.ui())
                .subscribe(WeatherDetailResponse -> handleGetWeatherDetailSuccess(WeatherDetailResponse),
                        error -> handleGetWeatherDetailFailed(error));

    }

    private void handleGetWeatherDetailFailed(Throwable error) {
        view.debug(error);
    }

    private void handleGetWeatherDetailSuccess(WeatherDetail weatherDetailResponse) {
        view.updateWeatherDetail(weatherDetailResponse);
    }
}

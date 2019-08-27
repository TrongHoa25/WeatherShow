package com.example.weathershow.ui.activity;

import com.example.weathershow.data.model.WeatherDetail;
import com.example.weathershow.ui.base.BasePresenter;
import com.example.weathershow.ui.base.BaseView;

public interface WeatherDetailContract {

    interface View extends BaseView{
        void updateWeatherDetail(WeatherDetail weatherDetail);
        void debug(Throwable erro);
    }

    interface Presenter extends BasePresenter{
        void getWeatherDetail(float lat, float lon, String appid);
    }

}

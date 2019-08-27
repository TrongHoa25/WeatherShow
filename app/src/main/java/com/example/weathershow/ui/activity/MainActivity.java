package com.example.weathershow.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.weathershow.R;
import com.example.weathershow.data.model.WeatherDetail;
import com.example.weathershow.data.repository.WeatherDetailRepository;
import com.example.weathershow.data.source.local.WeatherDetailLocalDataSource;
import com.example.weathershow.data.source.remote.WeatherDetailRemoteDataSource;
import com.example.weathershow.utils.AppConstants;
import com.example.weathershow.utils.rx.SchedulerProvider;

public class MainActivity extends AppCompatActivity implements WeatherDetailContract.View {
    WeatherDetail weatherDetail;
    WeatherDetailPresenter weatherDetailPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        WeatherDetailRepository weatherDetailRepository = WeatherDetailRepository.getInstance(WeatherDetailLocalDataSource.getInstance(),
                WeatherDetailRemoteDataSource.getInstance(this));
        weatherDetailPresenter = new WeatherDetailPresenter(this,
                weatherDetailRepository,
                SchedulerProvider.getInstance());
        weatherDetailPresenter.setView(this);
        weatherDetailPresenter.getWeatherDetail(35,139, AppConstants.APP_ID);
    }

    @Override
    public void updateWeatherDetail(WeatherDetail weatherDetail) {
        this.weatherDetail = weatherDetail;
    }

    @Override
    public void debug(Throwable erro) {
        Log.e("debug", erro.getMessage());
    }
}

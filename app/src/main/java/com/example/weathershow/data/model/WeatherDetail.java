package com.example.weathershow.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherDetail implements Parcelable {

    @SerializedName("coord")
    @Expose
    private Coord coord;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather;

    @SerializedName("base")
    @Expose
    String base;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("visibility")
    @Expose
    private float visibility;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    @SerializedName("dt")
    @Expose
    private double dt;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    @SerializedName("timezone")
    @Expose
    float timezone;

    @SerializedName("id")
    @Expose
    float id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("code")
    @Expose
    private int code;

    @Override
    public String toString() {
        return "WeatherDetail{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }

    public WeatherDetail() {
    }

    protected WeatherDetail(Parcel in) {
        this.coord = (Coord) in.readValue((Coord.class.getClassLoader()));
        this.weather = (List<Weather>) in.readValue((Weather.class.getClassLoader()));
        this.base = (String) in.readValue(String.class.getClassLoader());
        this.main = (Main) in.readValue((Main.class.getClassLoader()));
        this.visibility = (float) in.readValue(Float.class.getClassLoader());
        this.wind = (Wind) in.readValue(Wind.class.getClassLoader());
        this.clouds = (Clouds) in.readValue(Clouds.class.getClassLoader());
        this.dt = (double) in.readValue(Double.class.getClassLoader());
        this.sys = (Sys) in.readValue((Wind.class.getClassLoader()));
        this.timezone = (float) in.readValue(float.class.getClassLoader());
        this.id = (float) in.readValue(Float.class.getClassLoader());
        this.name = (String) in.readValue(String.class.getClassLoader());
        this.code = (int) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<WeatherDetail> CREATOR = new Creator<WeatherDetail>() {
        @Override
        public WeatherDetail createFromParcel(Parcel in) {
            return new WeatherDetail(in);
        }

        @Override
        public WeatherDetail[] newArray(int size) {
            return new WeatherDetail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(coord);
        parcel.writeValue(weather);
        parcel.writeValue(base);
        parcel.writeValue(main);
        parcel.writeValue(visibility);
        parcel.writeValue(wind);
        parcel.writeValue(clouds);
        parcel.writeValue(dt);
        parcel.writeValue(sys);
        parcel.writeValue(timezone);
        parcel.writeValue(id);
        parcel.writeValue(name);
        parcel.writeValue(code);
    }

    private class Clouds{
        @SerializedName("all")
        @Expose
        int all;
    }
    private class Sys{
        @SerializedName("type")
        @Expose
        int type;

        @SerializedName("id")
        @Expose
        float id;

        @SerializedName("country")
        @Expose
        String country;

        @SerializedName("sunrise")
        @Expose
        double sunrise;

        @SerializedName("sunset")
        @Expose
        double sunset;
    }

    private class Weather{
        @SerializedName("id")
        @Expose
        float id;

        @SerializedName("main")
        @Expose
        String main;

        @SerializedName("description")
        @Expose
        String description;

        @SerializedName("icon")
        @Expose
        String icon;
    }

    private class Main{

        @SerializedName("temp")
        @Expose
        float temp;

        @SerializedName("pressure")
        @Expose
        float pressure;

        @SerializedName("humidity")
        @Expose
        float humidity;

        @SerializedName("temp_min")
        @Expose
        float temp_min;

        @SerializedName("temp_max")
        @Expose
        float temp_max;

    }

    private class Wind {

        @SerializedName("speed")
        @Expose
        float speed;

        @SerializedName("deg")
        @Expose
        float deg;
    }

    private class Coord{

        @SerializedName("lon")
        @Expose
        float lon;

        @SerializedName("lat")
        @Expose
        float lat;
    }

}

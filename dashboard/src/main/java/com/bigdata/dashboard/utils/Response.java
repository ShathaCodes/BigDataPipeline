package com.bigdata.dashboard.utils;

import java.io.Serializable;
import java.util.List;

import com.bigdata.dashboard.entity.Temperature;
import com.bigdata.dashboard.entity.Humidity;


public class Response implements Serializable {
    private List<Temperature> temperatures;
    private List<Humidity> humidities;

    public List<Temperature> getTemperature() {
        return temperatures;
    }

    public void setTemperature(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public List<Humidity> getHumidity() {
        return humidities;
    }

    public void setHumidity(List<Humidity> humidities) {
        this.humidities = humidities;
    }

   
}

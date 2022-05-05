package com.bigdata.dashboard.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bigdata.dashboard.entity.Temperature;
import com.bigdata.dashboard.entity.Humidity;
import com.bigdata.dashboard.repository.TemperatureRepository;
import com.bigdata.dashboard.repository.HumidityRepository;

/**
 * Service class to send data messages to dashboard ui at fixed interval using
 * web-socket.
 */
@Service
public class DataService {

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	private TemperatureRepository temperatureRepository;

	@Autowired
	private HumidityRepository humidityRepository;

	// Method sends data message in every 15 seconds.
	@Scheduled(fixedRate = 15000)
	public void trigger() {
		System.out.println("triggered");
		List<Temperature> temperatures = new ArrayList<>();
		List<Humidity> humidities = new ArrayList<>();

		Long time = new Date().getTime();
		Date date = new Date(time - time % ( 60 * 1000)); // get data from the last minute
		System.out.println(date);

		temperatureRepository.findTemperatureByDate(date).forEach(e -> temperatures.add(e));
		humidityRepository.findHumidityByDate(date).forEach(e -> humidities.add(e));

		for (Temperature t : temperatures) {
			System.out.println(t);
		}
		for (Humidity h : humidities) {
			System.out.println(h);
		}

		// prepare response
		Response response = new Response();
		response.setHumidity(humidities);
		response.setTemperature(temperatures);

		// send to ui
		this.template.convertAndSend("/topic/data", response);
	}

}

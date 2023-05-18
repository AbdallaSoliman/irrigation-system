package com.banquemisr.irrigationsystem.service;

import com.banquemisr.irrigationsystem.integration.*;
import com.banquemisr.irrigationsystem.model.*;
import com.banquemisr.irrigationsystem.model.enumerate.*;
import com.banquemisr.irrigationsystem.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.actuate.web.exchanges.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.time.temporal.*;
import java.util.*;

@Service
public class AutomaticIrrigation {

    final LandRepository landRepository;
    final LandConfigurationRepository landConfigurationRepository;
    final SlotRepository slotRepository;
    final AlertRepository alertRepository;
    final SensorDevice sensorDevice;
    @Value("${automaticirrigation.sensor.retrycalls}")
    private Integer retryCalls;


    public AutomaticIrrigation(LandRepository landRepository, LandConfigurationRepository landConfigurationRepository, SlotRepository slotRepository, AlertRepository alertRepository, SensorDevice sensorDevice) {
        this.landRepository = landRepository;
        this.landConfigurationRepository = landConfigurationRepository;
        this.slotRepository = slotRepository;
        this.alertRepository = alertRepository;
        this.sensorDevice = sensorDevice;
    }

    @Scheduled(fixedRateString = "${automaticirrigation.scheduled.fixedrate}", initialDelay = 1000)
    public void IntegrationWithSensors() {
        //  Integration interface with the sensor device once a plot of land need to be irrigated
        //get all land need to be irrigated
        List<LandConfiguration> allLandNeedIrrigation = landConfigurationRepository.getAllLandNeedIrrigation();
        //send it to each sensor
        allLandNeedIrrigation.stream().forEach(landConfiguration -> {
            landConfiguration.getLand().getSlotSet().forEach(slot -> {
                if (slot.getRetryCount() < retryCalls) {
                    SensorConfig sensorConfig = new SensorConfig(slot.getSensorDeviceLink(),
                            landConfiguration.getIrrigateEvery(),
                            landConfiguration.getDurationPerOnce(),
                            landConfiguration.getWaterAmount());

                    HttpExchange.Response response = sensorDevice.start(sensorConfig);
                    if (response.getStatus() == 200) {
                        // Update the status of the slot once the request is successfully sent
                        slotRepository.updateStateById(SlotStatus.OPEN, slot.getId());
                        LocalDateTime nextIrrigationTime = landConfiguration.getLand().getNextIrrigationTime() != null ?
                        landConfiguration.getLand().getNextIrrigationTime() .plus(landConfiguration.getIrrigateEvery(), ChronoUnit.MILLIS)
                                : LocalDateTime.now().plus(landConfiguration.getIrrigateEvery(), ChronoUnit.MILLIS);
                        //update land nextIrrigationTime
                        landRepository.updateNextIrrigationTimeById(nextIrrigationTime, landConfiguration.getLand().getId());
                    } else {
                        // Retry calls to the sensor device in case the sensor not available
                        //(pre configured )
                        slotRepository.updateRetryCountById(slot.getRetryCount() + 1, slot.getId());
                    }
                } else {
                    //Alerting system to be implemented in case the sensor not
                    //available and after exceeding the retry times.
                    alertRepository.save(new Alert("sensor not available",slot.getSensorDeviceLink()));
                }
            });


        });


    }
}

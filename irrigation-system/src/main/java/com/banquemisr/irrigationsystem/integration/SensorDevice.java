package com.banquemisr.irrigationsystem.integration;

import org.springframework.boot.actuate.web.exchanges.*;
import org.springframework.stereotype.*;


public interface SensorDevice {
    HttpExchange.Response start(SensorConfig sensorConfig);

}

package com.banquemisr.irrigationsystem.integration;

import org.springframework.boot.actuate.web.exchanges.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class SensorDeviceMoc implements SensorDevice{
    @Override
    public HttpExchange.Response start(SensorConfig sensorConfig) {
        if("ERROR".equals(sensorConfig.sensorDeviceLink()))
        return new HttpExchange.Response(400,new HashMap<>());
        return new HttpExchange.Response(200,new HashMap<>());
    }
}

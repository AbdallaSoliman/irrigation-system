package com.banquemisr.irrigationsystem.integration;

public record SensorConfig(String sensorDeviceLink,
                           Long irrigateEvery,
                           Long durationPerOnce,
                           Long waterAmount) {
}

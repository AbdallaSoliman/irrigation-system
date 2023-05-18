package com.banquemisr.irrigationsystem.dto;

public record CropDto(String name,
                      Integer totalGrowingPeriodPerDay,
                      Integer cropWaterNeed) {
}

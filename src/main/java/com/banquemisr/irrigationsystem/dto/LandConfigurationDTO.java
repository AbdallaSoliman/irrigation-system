package com.banquemisr.irrigationsystem.dto;

import io.swagger.v3.oas.annotations.media.*;

import java.time.*;

public record LandConfigurationDTO(LocalDateTime startDate,
                                   LocalDateTime endDate,
                                   @Schema(example = "7d00bb7c-ce60-472f-81dd-5d1ff3c0dc4f") String cropId,
                                   Long irrigateEvery,
                                   Long durationPerOnce,
                                   Long waterAmount) {
}

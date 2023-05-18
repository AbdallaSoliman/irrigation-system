package com.banquemisr.irrigationsystem.dto;

import io.swagger.v3.oas.annotations.media.*;

import java.util.*;

public record LandResponseDTO(UUID id,
                              @Schema(example = "100") Double area,
                              @Schema(example = "Abdalla Soliman") String ownerName,
                              Set<SlotDTO> slotSet) {
}

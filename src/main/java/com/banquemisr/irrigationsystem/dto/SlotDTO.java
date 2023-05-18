package com.banquemisr.irrigationsystem.dto;

import com.banquemisr.irrigationsystem.model.enumerate.*;
import io.swagger.v3.oas.annotations.media.*;

public record SlotDTO(@Schema(example = "1") Integer code,
        @Schema(example = "CLOSE") SlotStatus state) {
}

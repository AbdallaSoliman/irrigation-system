package com.banquemisr.irrigationsystem.controller;

import com.banquemisr.irrigationsystem.dto.*;
import com.banquemisr.irrigationsystem.service.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springdoc.core.annotations.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Validated
@RestController
@RequestMapping("/api/land")
public class LandController {

    private final LandService landService;

    public LandController(LandService landService) {
        this.landService = landService;
    }

    @Tag(name = "1. Add a new Land")
    @Operation(
            operationId = "addLand",
            summary = "Add a new Land",
            description = "Add new plot of land")
    @PostMapping
    public ResponseEntity<?> addLand(
            @Validated @RequestBody LandRequestDTO landRequestDTO) {

        return landService.addLand(landRequestDTO);
    }

    @Tag(name = "2. Configure Land")
    @Operation(
            operationId = "configureLand",
            summary = "Configure  Land",
            description = "Configure a plot of land")
    @PostMapping("{landId}/configuration")
    public ResponseEntity<?> configureLand(
            @PathVariable String landId,
            @Validated @RequestBody LandConfigurationDTO landConfigurationDTO) {

        return landService.configureLand(landId, landConfigurationDTO);
    }

    @Tag(name = "3. Edit Land")
    @Operation(
            operationId = "editLand",
            summary = "Edit  Land",
            description = "Edit a plot of land")
    @PutMapping("{landId}")
    public ResponseEntity<?> editLand(
            @PathVariable UUID landId,
            @Validated @RequestBody LandRequestDTO landRequestDTO) {

        return landService.editLand(landId, landRequestDTO);
    }

    @Tag(name = "4. Get all Lands")
    @Operation(
            operationId = "getLands",
            summary = "Get all Lands",
            description = "List all plots and it's details")
    @GetMapping
    public Page<LandResponseDTO> getLands(@ParameterObject Pageable pageable) {

        return landService.getAll(pageable);
    }
}

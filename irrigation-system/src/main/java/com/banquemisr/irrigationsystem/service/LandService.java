package com.banquemisr.irrigationsystem.service;

import com.banquemisr.irrigationsystem.dto.*;
import com.banquemisr.irrigationsystem.mapper.*;
import com.banquemisr.irrigationsystem.message.constant.*;
import com.banquemisr.irrigationsystem.message.util.*;
import com.banquemisr.irrigationsystem.model.*;
import com.banquemisr.irrigationsystem.repository.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class LandService {
    private final LandRepository landRepository;
    private final LandConfigurationRepository landConfigurationRepository;

    private final LandMapper landMapper;
    private final LandConfigurationMapper landConfigurationMapper;


    public LandService(LandRepository landRepository, LandConfigurationRepository landConfigurationRepository, LandMapper landMapper, LandConfigurationMapper landConfigurationMapper) {
        this.landRepository = landRepository;
        this.landConfigurationRepository = landConfigurationRepository;
        this.landMapper = landMapper;
        this.landConfigurationMapper = landConfigurationMapper;
    }

    public ResponseEntity<?> addLand(LandRequestDTO landRequestDTO) {
        Land land = landMapper.toEntity(landRequestDTO);
        landRepository.save(land);
        return new MessageUtilities().getFormattedSuccessMessage(MessagesCode.ADDED_SUCCESSFULLY_WITH_ID, "Land", land.getId());
    }

    public ResponseEntity<?> configureLand(String landId, LandConfigurationDTO landConfigurationDTO) {
        LandConfiguration landConfiguration = landConfigurationMapper.toEntity(landId, landConfigurationDTO);
        landConfigurationRepository.save(landConfiguration);
        return new MessageUtilities().getSuccessCustomMessage(MessagesCode.SUCCESS_OPERATION);
    }

    public ResponseEntity<?> editLand(UUID landId, LandRequestDTO landRequestDTO) {
        Land land = landConfigurationRepository.findById(landId).get().getLand();
        landMapper.partialUpdate(landRequestDTO, land);
        return new MessageUtilities().getSuccessCustomMessage(MessagesCode.SUCCESS_OPERATION);
    }

    public Page<LandResponseDTO> getAll(Pageable pageable) {
        return landRepository.findAll(pageable).map(landMapper::toDTO);
    }
}

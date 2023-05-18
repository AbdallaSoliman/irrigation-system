package com.banquemisr.irrigationsystem.mapper;

import com.banquemisr.irrigationsystem.dto.*;
import com.banquemisr.irrigationsystem.model.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {LandMapper.class,CropMapper.class})
public interface LandConfigurationMapper {
    LandConfiguration toEntity(LandConfigurationDTO landConfigurationDTO);

    LandConfigurationDTO toDTO(LandConfiguration landConfiguration);

    @Mapping(source = "landId", target = "land")
    @Mapping(source = "landConfigurationDTO.cropId", target = "crop")
    LandConfiguration toEntity(String landId, LandConfigurationDTO landConfigurationDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LandConfiguration partialUpdate(LandConfigurationDTO landConfigurationDTO, @MappingTarget LandConfiguration landConfiguration);
}
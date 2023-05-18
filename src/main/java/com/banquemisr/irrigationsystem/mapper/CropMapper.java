package com.banquemisr.irrigationsystem.mapper;

import com.banquemisr.irrigationsystem.dto.*;
import com.banquemisr.irrigationsystem.model.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,uses = {ReferenceMapper.class})
public interface CropMapper {
    Crop toEntity(CropDto cropDto);

    CropDto toDto(Crop crop);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Crop partialUpdate(CropDto cropDto, @MappingTarget Crop crop);

    Crop toEntity(String id);
}
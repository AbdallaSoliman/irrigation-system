package com.banquemisr.irrigationsystem.mapper;

import com.banquemisr.irrigationsystem.dto.*;
import com.banquemisr.irrigationsystem.model.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,uses = SlotMapper.class)
public interface SlotMapper {
    Slot toEntity(SlotDTO slotDTO);

    SlotDTO toDto(Slot slot);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Slot partialUpdate(SlotDTO slotDTO, @MappingTarget Slot slot);

}
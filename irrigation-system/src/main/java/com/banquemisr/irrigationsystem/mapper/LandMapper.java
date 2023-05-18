package com.banquemisr.irrigationsystem.mapper;

import com.banquemisr.irrigationsystem.dto.*;
import com.banquemisr.irrigationsystem.model.*;
import org.mapstruct.*;
import org.springframework.data.domain.*;

import java.util.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,uses = {ReferenceMapper.class,SlotMapper.class})
public interface LandMapper {
//    @Mapping(source = "",target = "land")
    Land toEntity(LandRequestDTO landRequestDTO);

    LandResponseDTO toDTO(Land land);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Land partialUpdate(LandRequestDTO landRequestDTO, @MappingTarget Land land);

    Land toEntity(String id);

//    Page<LandRequestDTO> getAll(Page<Land> landList);
}
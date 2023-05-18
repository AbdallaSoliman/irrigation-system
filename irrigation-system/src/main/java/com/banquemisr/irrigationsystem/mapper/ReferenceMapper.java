package com.banquemisr.irrigationsystem.mapper;

import jakarta.persistence.*;
import org.mapstruct.*;
import org.springframework.lang.*;

import java.util.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @ObjectFactory
    public <T> T map(@NonNull final UUID id, @TargetType Class<T> type) {
        return entityManager.getReference(type, id);
    }
}

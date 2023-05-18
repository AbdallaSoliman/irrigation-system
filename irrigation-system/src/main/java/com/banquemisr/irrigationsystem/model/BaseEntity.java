package com.banquemisr.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.*;
import java.util.*;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ColumnDefault("random_uuid()")
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}

package com.banquemisr.irrigationsystem.model;

import com.banquemisr.irrigationsystem.model.enumerate.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint( columnNames = { "CODE", "LAND_ID" } ) } )
@Getter
@Setter
public class Slot extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private SlotStatus state;
    private Long duration;//working duration in ms
    private LocalDateTime lastOpenTime;

    private Integer code;

    private String sensorDeviceLink;
    private Integer retryCount=0;
    @ManyToOne
    private Land land;
}

package com.banquemisr.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@Getter
@Setter
public class LandConfiguration extends BaseEntity {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Long irrigateEvery;//ms
    private Long durationPerOnce;//ms
    private Long waterAmount;//mm

    @ManyToOne
    private Crop crop;
    @ManyToOne
    private Land land;


}

package com.banquemisr.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Crop extends BaseEntity {

    private String name;
    private Integer totalGrowingPeriodPerDay;
    private Integer cropWaterNeed;// mm/total growing period

}

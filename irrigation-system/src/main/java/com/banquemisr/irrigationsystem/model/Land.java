package com.banquemisr.irrigationsystem.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Land extends BaseEntity {


    private Double area;
    private String ownerName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "land",fetch = FetchType.EAGER)
    private Set<Slot> slotSet;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "land")
    private Set<LandConfiguration> landConfigurationSet;
    private LocalDateTime nextIrrigationTime;



    public void addSlot(Slot slot) {
        if (this.slotSet == null) {
            this.slotSet = new HashSet<>();
        }
        slotSet.add(slot);
        slot.setLand(this);
    }
}

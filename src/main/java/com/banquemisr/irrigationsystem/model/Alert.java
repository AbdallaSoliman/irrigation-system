package com.banquemisr.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alert extends BaseEntity {

    private String message;
    private String sensorDeviceLink;

}

package com.project.CarService.dto.vehicle;

import com.project.CarService.data.entity.Brand;
import lombok.*;

import java.time.LocalDate;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleClientDTO {

    private long id;
    private String regNumber;

    private Brand brand;

    private LocalDate productionDate;

    private String model;

    private String clientName;
}

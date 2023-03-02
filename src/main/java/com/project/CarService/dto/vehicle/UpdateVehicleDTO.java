package com.project.CarService.dto.vehicle;

import com.project.CarService.data.entity.Brand;
import com.project.CarService.data.entity.Client;
import lombok.*;

import java.time.LocalDate;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateVehicleDTO {

    private long id;
    private String regNumber;

    private Brand brand;

    private LocalDate productionDate;

    private String model;

    private Client client;
}

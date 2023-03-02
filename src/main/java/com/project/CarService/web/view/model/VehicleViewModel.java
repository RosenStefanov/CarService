package com.project.CarService.web.view.model;

import com.project.CarService.data.entity.Brand;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleViewModel {

    private long id;

    private String regNumber;


    private Brand brand;


    private LocalDate productionDate;

    private String model;

    private ClientViewModel client;
}

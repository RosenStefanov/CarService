package com.project.CarService.dto.vehicle;

import com.project.CarService.data.entity.Brand;
import com.project.CarService.data.entity.ServiceDone;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleServiceDonesDTO {

    private long id;
    private String regNumber;

    private Brand brand;

    private LocalDate productionDate;

    private String model;

    private List<ServiceDone> serviceDones;
}

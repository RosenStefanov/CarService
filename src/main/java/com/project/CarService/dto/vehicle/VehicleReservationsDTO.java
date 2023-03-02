package com.project.CarService.dto.vehicle;

import com.project.CarService.data.entity.Brand;
import com.project.CarService.data.entity.Reservation;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleReservationsDTO {

    private long id;
    private String regNumber;

    private Brand brand;

    private LocalDate productionDate;

    private String model;

    private List<Reservation> reservations;
}

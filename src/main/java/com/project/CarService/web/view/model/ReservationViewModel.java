package com.project.CarService.web.view.model;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationViewModel {
    private long id;

    private LocalDate reservationDate;


    private CarServiceViewModel carService;


    private ClientViewModel client;


    private VehicleViewModel vehicle;
}

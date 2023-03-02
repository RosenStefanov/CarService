package com.project.CarService.web.view.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationViewModel {
    @NotNull
    private LocalDate reservationDate;

    @NotNull
    private CarServiceViewModel carService;

    @NotNull
    private ClientViewModel client;

    @NotNull
    private VehicleViewModel vehicle;
}

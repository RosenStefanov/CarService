package com.project.CarService.dto.reservation;

import com.project.CarService.data.entity.CarService;
import com.project.CarService.data.entity.Client;
import com.project.CarService.data.entity.Vehicle;
import lombok.*;

import java.time.LocalDate;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateReservationDTO {

    private LocalDate reservationDate;

    private CarService carService;

    private Client client;

    private Vehicle vehicle;
}

package com.project.CarService.dto.carservice;

import com.project.CarService.data.entity.Reservation;
import lombok.*;

import java.util.List;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarServiceReservationsDTO {

    private String name;

    private List<Reservation> reservations;


}

package com.project.CarService.dto.reservation;

import lombok.*;

import java.time.LocalDate;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationClientDTO {

    private LocalDate reservationDate;

    private String clientName;
}

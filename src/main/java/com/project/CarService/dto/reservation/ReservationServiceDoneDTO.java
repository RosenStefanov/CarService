package com.project.CarService.dto.reservation;

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
public class ReservationServiceDoneDTO {
    private LocalDate reservationDate;

    private List<ServiceDone> serviceDones;
}

package com.project.CarService.dto.servicedone;

import com.project.CarService.data.entity.Reservation;
import com.project.CarService.data.entity.TypeOfService;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceDoneDTO {

    private long id;
    private Reservation reservation;

    private Double price;

    private TypeOfService typeOfService;
}

package com.project.CarService.web.view.model;

import com.project.CarService.data.entity.TypeOfService;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateServiceDoneViewModel {

    private ReservationViewModel reservation;

    private Double price;

    private TypeOfService typeOfService;
}

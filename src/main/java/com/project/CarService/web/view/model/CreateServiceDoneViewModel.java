package com.project.CarService.web.view.model;

import com.project.CarService.data.entity.TypeOfService;
import lombok.*;

import javax.validation.constraints.NotNull;
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateServiceDoneViewModel {

    @NotNull
    private ReservationViewModel reservation;

    private Double price;


    private TypeOfService typeOfService;
}

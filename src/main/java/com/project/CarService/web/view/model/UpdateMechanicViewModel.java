package com.project.CarService.web.view.model;

import com.project.CarService.data.entity.TypeOfService;
import lombok.*;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMechanicViewModel {

    @NotNull
    private String name;

    private TypeOfService qualification;

    private CarServiceViewModel carService;
}

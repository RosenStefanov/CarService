package com.project.CarService.dto.mechanic;

import com.project.CarService.data.entity.CarService;
import com.project.CarService.data.entity.TypeOfService;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateMechanicDTO {

    private long id;
    private String name;

    private TypeOfService qualification;

    private CarService carService;

}

package com.project.CarService.dto.carservice;

import com.project.CarService.data.entity.Mechanic;
import lombok.*;

import java.util.List;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarServiceMechanicsDTO {

    private String name;

    private List<Mechanic> mechanics;

}

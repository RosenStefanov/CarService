package com.project.CarService.dto.client;

import com.project.CarService.data.entity.Vehicle;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientVehicleDTO {

    private String name;


    private List<Vehicle> vehicles;
}

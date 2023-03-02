package com.project.CarService.dto.carservice;

import com.project.CarService.data.entity.ServiceDone;
import lombok.*;

import java.util.List;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarServiceServiceDoneDTO {
    private String name;

    private List<ServiceDone> serviceDones;
}

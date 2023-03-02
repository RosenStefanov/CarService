package com.project.CarService.dto.carservice;

import com.project.CarService.data.entity.Brand;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarServiceDTO {

    private long id;
    private String name;

    private boolean worksWithAllBrands;

    private Brand brand;


}

package com.project.CarService.web.view.model;

import com.project.CarService.data.entity.Brand;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarServiceViewModel {

    private String name;

    private boolean worksWithAllBrands;

    private Brand brand;
}

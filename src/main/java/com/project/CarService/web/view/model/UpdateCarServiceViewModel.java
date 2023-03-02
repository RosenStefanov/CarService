package com.project.CarService.web.view.model;

import com.project.CarService.data.entity.Brand;
import lombok.*;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarServiceViewModel {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String name;

    @NotNull
    private boolean worksWithAllBrands;

    @Enumerated
    private Brand brand;
}

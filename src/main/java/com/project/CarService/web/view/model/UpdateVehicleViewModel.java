package com.project.CarService.web.view.model;

import com.project.CarService.data.entity.Brand;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVehicleViewModel {
    @NotBlank
    @Size(min = 8, max = 8, message="8")
    private String regNumber;

    @NotNull
    private Brand brand;

    @NotNull
    private LocalDate productionDate;

    @NotNull
    private String model;

    private ClientViewModel client;
}

package com.project.CarService.web.view.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientViewModel {

    @NotNull
    private String name;
}

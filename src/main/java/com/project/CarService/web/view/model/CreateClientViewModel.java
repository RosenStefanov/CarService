package com.project.CarService.web.view.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientViewModel {
    @NotNull
    private String name;
}

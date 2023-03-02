package com.project.CarService.web.view.model;


import com.project.CarService.data.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RegisterViewModel {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Set<Role> role;
}

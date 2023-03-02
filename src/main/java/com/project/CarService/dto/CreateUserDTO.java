package com.project.CarService.dto;

import com.project.CarService.data.entity.Role;
import lombok.*;

import java.util.Set;
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUserDTO {

    private String username;

    private String password;

    private Set<Role> role;

}

package com.project.CarService.services;

import com.project.CarService.dto.CreateUserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    CreateUserDTO createUser(CreateUserDTO createUserDTO);

}

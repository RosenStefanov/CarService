package com.project.CarService.web.api;


import com.project.CarService.dto.CreateUserDTO;
import com.project.CarService.services.UserService;
import com.project.CarService.web.view.model.RegisterViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@AllArgsConstructor
public class RegisterApiController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/")
    public void register(@RequestBody RegisterViewModel registerViewModel) {
        final CreateUserDTO createUserDto = modelMapper.map(registerViewModel, CreateUserDTO.class);

        userService.createUser(createUserDto);
    }
}

package com.project.CarService.services.implementations;

import com.project.CarService.data.entity.User;
import com.project.CarService.data.repository.UserRepository;
import com.project.CarService.dto.CreateUserDTO;
import com.project.CarService.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final ModelMapper modelMapper;


    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }



    @Override
    public CreateUserDTO createUser(CreateUserDTO createUserDTO){
        createUserDTO.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        return modelMapper
                .map(userRepository
                        .save(modelMapper
                                .map(createUserDTO, User.class)), CreateUserDTO.class);

    };
}

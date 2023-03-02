package com.project.CarService.service.implementation;

import com.project.CarService.data.entity.CarService;
import com.project.CarService.data.repository.CarServiceRepository;
import com.project.CarService.dto.carservice.CarServiceDTO;
import com.project.CarService.services.implementations.CarServiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@DataJpaTest
public class CarServiceServiceImplTest {
    @Mock
    private CarServiceRepository carServiceRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CarServiceServiceImpl carServiceService;

    private CarService carService;

    private CarServiceDTO carServiceDTO;


    @BeforeEach
    public void init() {
        carService = new CarService();
        carService.setId(3L);
        carService.setName("Pri Pesho");
        carServiceRepository.save(carService);
    }

    @Test
    void getCarService(){
        given(carServiceRepository.findById(3L))
                .willReturn(Optional.of(carService));

        CarServiceDTO carServiceDTO1 =
                carServiceService.
                        getCarService(carService.getId());

        assertThat(carServiceDTO1.getId()).isEqualTo(carService.getId());

    }


}

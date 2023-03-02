package com.project.CarService.data.repository;

import com.project.CarService.data.entity.Brand;
import com.project.CarService.data.entity.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarServiceRepositoryTest {

    @Autowired
    private CarServiceRepository carServiceRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private CarService carService;

    @BeforeEach
    public void setup() {
        carService = new CarService();
        carService.setName("Pri Pesho");
        carService.setWorksWithAllBrands(false);
        carService.setBrand(Brand.VW);

    }

    @Test
    void saveCarServiceTest() {
        CarService carService1 = new CarService();
        carService1.setName("Pri Gosho");
        carService1.setWorksWithAllBrands(true);
        CarService savedCarService = carServiceRepository.save(carService1);
        assertThat(savedCarService).isNotNull();
    }

    @Test
    void findAllByFoundNameTest() {
        testEntityManager.persistAndFlush(carService);
        assertThat(carServiceRepository.findAllByName("Pri Pesho").size()).isEqualTo(1);
    }

    @Test
    void updateCarServiceBrandTest() {
        testEntityManager.persistAndFlush(carService);
        carService.setBrand(Brand.BMW);
        carServiceRepository.save(carService);
        assertThat(carService.getBrand()).isEqualTo(Brand.BMW);
    }


}

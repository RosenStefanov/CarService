package com.project.CarService.data.repository;

import com.project.CarService.data.entity.CarService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarServiceRepository extends JpaRepository<CarService, Long> {

    List<CarService> findAllByNameAndWorksWithAllBrands(String carServiceName, boolean worksWithAll);

    List<CarService> findAllByName(String name);
}

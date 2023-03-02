package com.project.CarService.services;

import com.project.CarService.data.entity.CarService;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.carservice.CarServiceDTO;
import com.project.CarService.dto.carservice.CreateCarServiceDTO;
import com.project.CarService.dto.carservice.UpdateCarServiceDTO;

import java.util.List;

public interface CarServiceService {

    List<CarServiceDTO> getCarServices();

    CarService create(CreateCarServiceDTO createCarServiceDTO);

    UpdateCarServiceDTO updateCarService(long id, UpdateCarServiceDTO updateCarServiceDTO );

    void deleteCarService(long id);

    List<CarServiceDTO> getCarServicesByNameAndWorksWithAllBrands(String carServiceName, boolean worksWithAll);

    CarServiceDTO getCarService(long id);

    List<ServiceDone> getReservations(CarService carService);
}

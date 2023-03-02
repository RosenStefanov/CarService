package com.project.CarService.services.implementations;

import com.project.CarService.data.entity.CarService;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.data.repository.CarServiceRepository;
import com.project.CarService.dto.carservice.CarServiceDTO;
import com.project.CarService.dto.carservice.CreateCarServiceDTO;
import com.project.CarService.dto.carservice.UpdateCarServiceDTO;
import com.project.CarService.exeptions.ObjectNotFoundException;
import com.project.CarService.services.CarServiceService;
import com.project.CarService.services.ReservationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceServiceImpl implements CarServiceService {
    private final CarServiceRepository carServiceRepository;
    private final ReservationService reservationService;

    private final ModelMapper modelMapper;

    @Override
    public List<CarServiceDTO> getCarServices() {
        return carServiceRepository.findAll().stream()
                .map(this::convertToCarServiceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarService create(CreateCarServiceDTO createCarServiceDTO) {
        return carServiceRepository.save(modelMapper.map(createCarServiceDTO, CarService.class));
    }

    @Override
    public CarServiceDTO getCarService(long id) {
        return modelMapper.map(carServiceRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Invalid object Id:" + id)), CarServiceDTO.class);
    }

    @Override
    public UpdateCarServiceDTO updateCarService(long id, UpdateCarServiceDTO updateCarServiceDTO) {
        CarService carService = modelMapper.map(getCarService(id), CarService.class);
        carService.setName(updateCarServiceDTO.getName());
        carService.setWorksWithAllBrands(updateCarServiceDTO.isWorksWithAllBrands());
        carService.setBrand(updateCarServiceDTO.getBrand());
        return modelMapper.map(carServiceRepository.save(carService), UpdateCarServiceDTO.class);
    }

    @Override
    public void deleteCarService(long id) {
        carServiceRepository.deleteById(id);
    }


    private CarServiceDTO convertToCarServiceDTO(CarService carService) {
        return modelMapper.map(carService, CarServiceDTO.class);
    }
    @Override
    public List<CarServiceDTO> getCarServicesByNameAndWorksWithAllBrands(String carServiceName, boolean worksWithAll){
        return carServiceRepository.findAllByNameAndWorksWithAllBrands(carServiceName, worksWithAll).stream()
                .map(this::convertToCarServiceDTO)
                .collect(Collectors.toList());

    };

    public List<ServiceDone> getReservations(CarService carService){

        return reservationService.getServiceDoneByReservation(carService.getReservations());

    };
}

package com.project.CarService.web.api;

import com.project.CarService.data.entity.CarService;
import com.project.CarService.dto.carservice.CarServiceDTO;
import com.project.CarService.dto.carservice.CreateCarServiceDTO;
import com.project.CarService.dto.carservice.UpdateCarServiceDTO;
import com.project.CarService.services.CarServiceService;
import com.project.CarService.web.view.model.CreateCarServiceViewModel;
import com.project.CarService.web.view.model.UpdateCarServiceViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carservice")
public class CarServiceApiController {

    private final CarServiceService carServiceService;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<CarServiceDTO> getCarSerives() {

        return carServiceService.getCarServices();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarService createCarService(@RequestBody CreateCarServiceViewModel carServiceViewModel) {
        return carServiceService.create(modelMapper.map(carServiceViewModel, CreateCarServiceDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UpdateCarServiceDTO updateCarService(@PathVariable("id") long id, @RequestBody UpdateCarServiceViewModel carService){
        return carServiceService.updateCarService(id, modelMapper.map(carService, UpdateCarServiceDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCarService(@PathVariable long id) {
        carServiceService.deleteCarService(id);
    }

}

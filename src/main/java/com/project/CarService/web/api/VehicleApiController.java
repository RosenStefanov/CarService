package com.project.CarService.web.api;

import com.project.CarService.data.entity.Vehicle;
import com.project.CarService.dto.vehicle.CreateVehicleDTO;
import com.project.CarService.dto.vehicle.UpdateVehicleDTO;
import com.project.CarService.dto.vehicle.VehicleDTO;
import com.project.CarService.services.VehicleService;
import com.project.CarService.web.view.model.CreateVehicleViewModel;
import com.project.CarService.web.view.model.UpdateVehicleViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vehicle")
public class VehicleApiController {

    private final VehicleService vehicleService;

    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle createvehicle(@RequestBody CreateVehicleViewModel vehicle) {
        return vehicleService.create(modelMapper.map(vehicle, CreateVehicleDTO.class));
    }

    @GetMapping
    public List<VehicleDTO> getVehicles() {
        return vehicleService.getVehicles();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UpdateVehicleDTO updateVehicle(@PathVariable("id") long id, @RequestBody UpdateVehicleViewModel vehicle){
        return vehicleService.updateVehicle(id, modelMapper.map(vehicle, UpdateVehicleDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVehicle(@PathVariable long id) {
        vehicleService.deleteVehicle(id);
    }
}

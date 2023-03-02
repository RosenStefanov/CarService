package com.project.CarService.services;

import com.project.CarService.data.entity.Vehicle;
import com.project.CarService.dto.vehicle.CreateVehicleDTO;
import com.project.CarService.dto.vehicle.UpdateVehicleDTO;
import com.project.CarService.dto.vehicle.VehicleDTO;

import java.util.List;

public interface VehicleService {

    Vehicle create(CreateVehicleDTO createVehicleDTO);

    List<VehicleDTO> getVehicles();

    UpdateVehicleDTO updateVehicle(long id, UpdateVehicleDTO vehicle );

    void deleteVehicle(long id);

    VehicleDTO getVehicle(long id);
}

package com.project.CarService.services.implementations;

import com.project.CarService.data.entity.Vehicle;
import com.project.CarService.data.repository.VehicleRepository;
import com.project.CarService.dto.vehicle.CreateVehicleDTO;
import com.project.CarService.dto.vehicle.UpdateVehicleDTO;
import com.project.CarService.dto.vehicle.VehicleDTO;
import com.project.CarService.exeptions.ObjectNotFoundException;
import com.project.CarService.services.VehicleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    private final ModelMapper modelMapper;

    @Override
    public Vehicle create(CreateVehicleDTO createVehicleDTO) {
        return vehicleRepository.save(modelMapper.map(createVehicleDTO, Vehicle.class));
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        return vehicleRepository.findAll().stream()
                .map(this::convertToVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateVehicleDTO updateVehicle(long id, UpdateVehicleDTO vehicle) {
        Vehicle vehicle1 = modelMapper.map(getVehicle(id), Vehicle.class);
        vehicle1.setBrand(vehicle.getBrand());
        vehicle1.setRegNumber(vehicle.getRegNumber());
        vehicle1.setProductionDate(vehicle.getProductionDate());
        vehicle1.setClient(vehicle.getClient());
        vehicle1.setModel(vehicle.getModel());


        return modelMapper.map(vehicleRepository.save(vehicle1), UpdateVehicleDTO.class);
    }

    @Override
    public void deleteVehicle(long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public VehicleDTO getVehicle(long id) {
        return modelMapper.map(vehicleRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Invalid object Id:" + id)), VehicleDTO.class);
    }

    private VehicleDTO convertToVehicleDTO(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }
}

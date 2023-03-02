package com.project.CarService.services.implementations;

import com.project.CarService.data.entity.Mechanic;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.data.repository.MechanicRepository;
import com.project.CarService.dto.mechanic.CreateMechanicDTO;
import com.project.CarService.dto.mechanic.MechanicCarServiceDTO;
import com.project.CarService.dto.mechanic.MechanicDTO;
import com.project.CarService.dto.mechanic.UpdateMechanicDTO;
import com.project.CarService.exeptions.ObjectNotFoundException;
import com.project.CarService.services.CarServiceService;
import com.project.CarService.services.MechanicService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;

    private final CarServiceService carServiceService;

    private final ModelMapper modelMapper;

    @Override
    public Mechanic create(CreateMechanicDTO createMechanicDTO){
        return mechanicRepository.save(modelMapper.map(createMechanicDTO, Mechanic.class));

    }

    @Override
    public List<MechanicDTO> getMechanics() {
        return mechanicRepository.findAll().stream()
                .map(this::convertToMechanicDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateMechanicDTO updateMechanic(long id, UpdateMechanicDTO mechanic) {
        Mechanic mechanic1 = modelMapper.map(getMechanic(id), Mechanic.class);
        mechanic1.setName(mechanic.getName());
        mechanic1.setCarService(mechanic.getCarService());
        mechanic1.setQualification(mechanic.getQualification());

        return modelMapper.map(mechanicRepository.save(mechanic1), UpdateMechanicDTO.class);
    }

    @Override
    public void deleteMechanic(long id) {
        mechanicRepository.deleteById(id);
    }

    @Override
    public MechanicDTO getMechanic(long id) {
        return modelMapper.map(mechanicRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Invalid object Id:" + id)), MechanicDTO.class);
    }

    @Override
    public List<ServiceDone> getServiceDoneInMechanicWorkPlace(long id){

        MechanicCarServiceDTO mechanic = modelMapper.map(getMechanic(id), MechanicCarServiceDTO.class);
        return carServiceService.getReservations(mechanic.getCarService());


    };



    private MechanicDTO convertToMechanicDTO(Mechanic mechanic) {
        return modelMapper.map(mechanic, MechanicDTO.class);
    }
}

package com.project.CarService.services;

import com.project.CarService.data.entity.Mechanic;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.mechanic.CreateMechanicDTO;
import com.project.CarService.dto.mechanic.MechanicDTO;
import com.project.CarService.dto.mechanic.UpdateMechanicDTO;

import java.util.List;

public interface MechanicService {
    Mechanic create(CreateMechanicDTO createMechanicDTO);

    List<MechanicDTO> getMechanics();

    UpdateMechanicDTO updateMechanic(long id, UpdateMechanicDTO mechanic );

    void deleteMechanic(long id);

    MechanicDTO getMechanic(long id);

    List<ServiceDone> getServiceDoneInMechanicWorkPlace(long id);
}

package com.project.CarService.services;

import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.servicedone.CreateServiceDoneDTO;
import com.project.CarService.dto.servicedone.ServiceDoneDTO;
import com.project.CarService.dto.servicedone.UpdateServiceDoneDTO;

import java.util.List;

public interface ServiceDoneService {
    ServiceDone create(CreateServiceDoneDTO createServiceDoneDTO);

    List<ServiceDoneDTO> getServiceDones();

    UpdateServiceDoneDTO updateServiceDone(long id, UpdateServiceDoneDTO serviceDone );

    void deleteServiceDone(long id);

    ServiceDoneDTO getServiceDone(long id);
}

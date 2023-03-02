package com.project.CarService.services.implementations;

import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.data.repository.ServiceDoneRepository;
import com.project.CarService.dto.servicedone.CreateServiceDoneDTO;
import com.project.CarService.dto.servicedone.ServiceDoneDTO;
import com.project.CarService.dto.servicedone.UpdateServiceDoneDTO;
import com.project.CarService.exeptions.ObjectNotFoundException;
import com.project.CarService.services.ServiceDoneService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceDoneServiceImpl implements ServiceDoneService {

    private final ServiceDoneRepository serviceDoneRepository;

    private final ModelMapper modelMapper;


    @Override
    public ServiceDone create(CreateServiceDoneDTO createServiceDoneDTO) {
        return serviceDoneRepository.save(modelMapper.map(createServiceDoneDTO, ServiceDone.class));
    }

    @Override
    public List<ServiceDoneDTO> getServiceDones() {
        return serviceDoneRepository.findAll().stream()
                .map(this::convertToReservationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateServiceDoneDTO updateServiceDone(long id, UpdateServiceDoneDTO serviceDone) {
        ServiceDone serviceDone1 = modelMapper.map(getServiceDone(id), ServiceDone.class);
        serviceDone1.setPrice(serviceDone.getPrice());
        serviceDone1.setReservation(serviceDone.getReservation());
        serviceDone1.setTypeOfService(serviceDone.getTypeOfService());


        return modelMapper.map(serviceDoneRepository.save(serviceDone1), UpdateServiceDoneDTO.class);

    }

    @Override
    public void deleteServiceDone(long id) {
        serviceDoneRepository.deleteById(id);
    }

    @Override
    public ServiceDoneDTO getServiceDone(long id) {
        return modelMapper.map(serviceDoneRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Invalid object Id:" + id)), ServiceDoneDTO.class);
    }

    private ServiceDoneDTO convertToReservationDTO(ServiceDone serviceDone) {
        return modelMapper.map(serviceDone, ServiceDoneDTO.class);
    }
}

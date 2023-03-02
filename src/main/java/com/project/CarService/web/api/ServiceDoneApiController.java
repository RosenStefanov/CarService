package com.project.CarService.web.api;

import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.servicedone.CreateServiceDoneDTO;
import com.project.CarService.dto.servicedone.ServiceDoneDTO;
import com.project.CarService.dto.servicedone.UpdateServiceDoneDTO;
import com.project.CarService.services.ServiceDoneService;
import com.project.CarService.web.view.model.CreateServiceDoneViewModel;
import com.project.CarService.web.view.model.UpdateServiceDoneViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/serviceDone")
public class ServiceDoneApiController {
    private final ServiceDoneService serviceDoneService;

    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceDone createServiceDone(@RequestBody CreateServiceDoneViewModel serviceDone) {
        return serviceDoneService.create(modelMapper.map(serviceDone, CreateServiceDoneDTO.class));
    }

    @GetMapping
    public List<ServiceDoneDTO> getServiceDones() {
        return serviceDoneService.getServiceDones();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UpdateServiceDoneDTO updateServiceDone(@PathVariable("id") long id, @RequestBody UpdateServiceDoneViewModel serviceDone){
        return serviceDoneService.updateServiceDone(id, modelMapper.map(serviceDone, UpdateServiceDoneDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteServiceDone(@PathVariable long id) {
        serviceDoneService.deleteServiceDone(id);
    }
}

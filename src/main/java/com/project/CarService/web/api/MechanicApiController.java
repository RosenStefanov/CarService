package com.project.CarService.web.api;

import com.project.CarService.data.entity.Mechanic;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.mechanic.CreateMechanicDTO;
import com.project.CarService.dto.mechanic.MechanicDTO;
import com.project.CarService.dto.mechanic.UpdateMechanicDTO;
import com.project.CarService.services.MechanicService;
import com.project.CarService.web.view.model.CreateMechanicViewModel;
import com.project.CarService.web.view.model.UpdateMechanicViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mechanic")
public class MechanicApiController {

    private final MechanicService mechanicService;

    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mechanic createMechanic(@Valid @RequestBody CreateMechanicViewModel createMechanicViewModel) {
        return mechanicService.create(modelMapper.map(createMechanicViewModel, CreateMechanicDTO.class));
    }

    @GetMapping
    public List<MechanicDTO> getMechanics() {
        return mechanicService.getMechanics();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UpdateMechanicDTO updateMechanic(@PathVariable("id") long id, @RequestBody UpdateMechanicViewModel mechanic){
        return mechanicService.updateMechanic(id, modelMapper.map(mechanic, UpdateMechanicDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMechanic(@PathVariable long id) {
        mechanicService.deleteMechanic(id);
    }


    @RequestMapping("/serviceDoneInMechanicWorkPlace/{id}")
    public List<ServiceDone> getServiceDoneInMechanicWorkPlace(@PathVariable long id){  return mechanicService.getServiceDoneInMechanicWorkPlace(id);}
}

package com.project.CarService.web.api;

import com.project.CarService.data.entity.Client;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.client.ClientDTO;
import com.project.CarService.dto.client.CreateClientDTO;
import com.project.CarService.dto.client.UpdateClientDTO;
import com.project.CarService.services.ClientService;
import com.project.CarService.web.view.model.CreateClientViewModel;
import com.project.CarService.web.view.model.UpdateClientViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/client")
public class ClientApiController {

    private final ClientService clientService;

    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody CreateClientViewModel clientViewModel) {
        return clientService.create(modelMapper.map(clientViewModel, CreateClientDTO.class));
    }

    @GetMapping
    public List<ClientDTO> getClients() {
        return clientService.getClients();
    }



    @RequestMapping("/clientReservations/{id}")
    public List<ServiceDone> getClientReservations(@PathVariable long id){  return clientService.getClientReservations(id);}

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UpdateClientDTO updateClient(@PathVariable("id") long id, @RequestBody UpdateClientViewModel client){
        return clientService.updateClient(id, modelMapper.map(client, UpdateClientDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }
}

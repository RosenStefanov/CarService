package com.project.CarService.services;

import com.project.CarService.data.entity.Client;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.client.ClientDTO;
import com.project.CarService.dto.client.CreateClientDTO;
import com.project.CarService.dto.client.UpdateClientDTO;

import java.util.List;

public interface ClientService {

    Client create(CreateClientDTO createClientDTO);

    List<ClientDTO> getClients();

    UpdateClientDTO updateClient(long id, UpdateClientDTO client );

    void deleteClient(long id);

    public ClientDTO getClient(long id);

    List<ServiceDone> getClientReservations(long id);
}

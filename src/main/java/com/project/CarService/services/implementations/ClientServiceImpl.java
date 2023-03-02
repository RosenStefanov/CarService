package com.project.CarService.services.implementations;

import com.project.CarService.data.entity.Client;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.data.repository.CarServiceRepository;
import com.project.CarService.data.repository.ClientRepository;
import com.project.CarService.dto.client.ClientDTO;
import com.project.CarService.dto.client.ClientReservationDTO;
import com.project.CarService.dto.client.CreateClientDTO;
import com.project.CarService.dto.client.UpdateClientDTO;
import com.project.CarService.exeptions.ObjectNotFoundException;
import com.project.CarService.services.ClientService;
import com.project.CarService.services.ReservationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ReservationService reservationService;

    private final ModelMapper modelMapper;
    private final CarServiceRepository carServiceRepository;


    public Client create(CreateClientDTO createClientDTO){
        return clientRepository.save(modelMapper.map(createClientDTO, Client.class));
    };

    public List<ClientDTO> getClients(){
        return clientRepository.findAll().stream()
                .map(this::convertToClientDTO)
                .collect(Collectors.toList());

    }

    @Override
    public UpdateClientDTO updateClient(long id, UpdateClientDTO client) {
        Client client2 = modelMapper.map(getClient(id), Client.class);
        client2.setName(client.getName());

        return modelMapper.map(clientRepository.save(client2), UpdateClientDTO.class);
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }

    ;

    private ClientDTO convertToClientDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public ClientDTO getClient(long id) {
        return modelMapper.map(clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Invalid object Id:" + id)), ClientDTO.class);
    }

    @Override
    public List<ServiceDone> getClientReservations(long id) {
        ClientReservationDTO client = modelMapper.map(getClient(id), ClientReservationDTO.class);
         return reservationService.getServiceDoneByReservation(client.getReservations());
    }
}

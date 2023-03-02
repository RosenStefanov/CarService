package com.project.CarService.services.implementations;

import com.project.CarService.data.entity.Reservation;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.data.repository.ReservationRepository;
import com.project.CarService.dto.reservation.CreateReservationDTO;
import com.project.CarService.dto.reservation.ReservationDTO;
import com.project.CarService.dto.reservation.ReservationServiceDoneDTO;
import com.project.CarService.dto.reservation.UpdateReservationDTO;
import com.project.CarService.exeptions.ObjectNotFoundException;
import com.project.CarService.services.ReservationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    private final ModelMapper modelMapper;

    @Override
    public Reservation create(CreateReservationDTO createReservationDTO) {
        return reservationRepository.save(modelMapper.map(createReservationDTO, Reservation.class));
    }

    @Override
    public List<ReservationDTO> getReservations() {
        return reservationRepository.findAll().stream()
                .map(this::convertToReservationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateReservationDTO updateReservation(long id, UpdateReservationDTO reservation) {
        Reservation reservation1 = modelMapper.map(getReservation(id), Reservation.class);
        reservation1.setReservationDate(reservation.getReservationDate());
        reservation1.setClient(reservation.getClient());
        reservation1.setCarService(reservation.getCarService());
        reservation1.setVehicle(reservation.getVehicle());


        return modelMapper.map(reservationRepository.save(reservation1), UpdateReservationDTO.class);
    }

    @Override
    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public ReservationDTO getReservation(long id) {
        return modelMapper.map(reservationRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Invalid object Id:" + id)), ReservationDTO.class);
    }

    @Override
    public List<ServiceDone> getServiceDoneByReservation(List<Reservation> reservations) {
        List<ServiceDone> serviceDones = new ArrayList<>();
        reservations.forEach((temp) -> {
            ReservationServiceDoneDTO reservation = modelMapper.map(temp, ReservationServiceDoneDTO.class);
            serviceDones.addAll(reservation.getServiceDones());
        });

        return serviceDones;

    }

    private ReservationDTO convertToReservationDTO(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDTO.class);
    }
}

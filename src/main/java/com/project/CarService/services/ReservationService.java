package com.project.CarService.services;

import com.project.CarService.data.entity.Reservation;
import com.project.CarService.data.entity.ServiceDone;
import com.project.CarService.dto.reservation.CreateReservationDTO;
import com.project.CarService.dto.reservation.ReservationDTO;
import com.project.CarService.dto.reservation.UpdateReservationDTO;

import java.util.List;

public interface ReservationService {
    Reservation create(CreateReservationDTO createReservationDTO);

    List<ReservationDTO> getReservations();

    UpdateReservationDTO updateReservation(long id, UpdateReservationDTO reservation );

    void deleteReservation(long id);

    ReservationDTO getReservation(long id);

    List<ServiceDone> getServiceDoneByReservation(List<Reservation> reservations);
}

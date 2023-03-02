package com.project.CarService.web.api;

import com.project.CarService.data.entity.Reservation;
import com.project.CarService.dto.reservation.CreateReservationDTO;
import com.project.CarService.dto.reservation.ReservationDTO;
import com.project.CarService.dto.reservation.UpdateReservationDTO;
import com.project.CarService.services.ReservationService;
import com.project.CarService.web.view.model.CreateReservationViewModel;
import com.project.CarService.web.view.model.UpdateReservationViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationApiController {
    private final ReservationService reservationService;

    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody CreateReservationViewModel reservation) {
        return reservationService.create(modelMapper.map(reservation, CreateReservationDTO.class));
    }

    @GetMapping
    public List<ReservationDTO> getReservation() {
        return reservationService.getReservations();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UpdateReservationDTO updateReservation(@PathVariable("id") long id, @RequestBody UpdateReservationViewModel reservation){
        return reservationService.updateReservation(id, modelMapper.map(reservation, UpdateReservationDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteReservation(@PathVariable long id) {
        reservationService.deleteReservation(id);
    }
}

package com.project.CarService.dto.client;

import com.project.CarService.data.entity.Reservation;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDTO {

    private long id;
    private String name;

    private List<Reservation> reservations;


}

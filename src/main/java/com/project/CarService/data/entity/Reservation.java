package com.project.CarService.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation extends BaseEntity {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message="The date has to be in the future!")
    private LocalDate reservationDate;

    @NotNull
    @ManyToOne
    private CarService carService;

    @NotNull
    @ManyToOne
    private Client client;

    @NotNull
    @ManyToOne
    private Vehicle vehicle;

    @OneToMany(mappedBy = "reservation")
    @JsonIgnore
    private List<ServiceDone> serviceDones;
}

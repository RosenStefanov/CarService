package com.project.CarService.data.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "service_done")
public class ServiceDone extends BaseEntity {

    @NotNull
    @ManyToOne
    private Reservation reservation;

    private Double price;

    @Enumerated
    private TypeOfService typeOfService;

}

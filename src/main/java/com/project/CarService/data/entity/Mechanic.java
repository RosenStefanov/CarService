package com.project.CarService.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mechanics")
public class Mechanic extends BaseEntity{

    @NotNull
    private String name;

    @Enumerated
    private TypeOfService qualification;

    @ManyToOne
    @JoinColumn(name = "car_service_id")
    private CarService carService;


}

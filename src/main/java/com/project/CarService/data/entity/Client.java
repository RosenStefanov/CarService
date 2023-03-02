package com.project.CarService.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client extends BaseEntity{


    private String name;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Reservation> reservations;
}

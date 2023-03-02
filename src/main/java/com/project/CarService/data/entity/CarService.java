package com.project.CarService.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "car_service")
public class CarService extends BaseEntity {

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String name;

    private boolean worksWithAllBrands;


    @Enumerated
    private Brand brand;

    private int deleted;

    @OneToMany(mappedBy = "carService")
    @JsonIgnore
    private List<Mechanic> mechanics;

    @OneToMany(mappedBy = "carService")
    @JsonIgnore
    private List<Reservation> reservations;



}

package com.project.CarService.dto.client;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateClientDTO {
    private long id;

    private String name;
}

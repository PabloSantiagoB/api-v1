package com.mochanomods.test.pet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetUpdateDTO {
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    public PetUpdateDTO() {
    }

    public PetUpdateDTO(Long id, String nombre, String especie, String raza, String color) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
}

package com.mochanomods.test.pet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetCreateDTO {
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    public PetCreateDTO() {
    }

    public PetCreateDTO(String nombre, String especie, String raza, String color) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
}

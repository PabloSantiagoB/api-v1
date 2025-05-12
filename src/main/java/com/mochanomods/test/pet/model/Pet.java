package com.mochanomods.test.pet.model;

import com.mochanomods.test.owner.model.Owner;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pet_id;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet() {
    }

    public Pet(Long id, String nombre, String especie, String raza, String color) {
        this.pet_id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
}

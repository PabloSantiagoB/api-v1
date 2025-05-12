package com.mochanomods.test.owner.model;

import com.mochanomods.test.pet.model.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long owner_id;
    private String dni;
    private String first_name;
    private String last_name;
    private String phone;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

    public Owner() {
    }

    public Owner(Long id, String dni, String first_name, String last_name, String phone) {
        this.owner_id = id;
        this.dni = dni;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
}

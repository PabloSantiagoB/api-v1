package com.mochanomods.test.owner.dto;

import com.mochanomods.test.pet.dto.PetResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OwnerResponseDTO {
    private Long id;
    private String dni;
    private String first_name;
    private String last_name;
    private String phone;
    private List<PetResponseDTO> pets;

    public OwnerResponseDTO() {
    }

    public OwnerResponseDTO(Long id, String dni, String first_name, String last_name, String phone, List<PetResponseDTO> pets) {
        this.id = id;
        this.dni = dni;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.pets = pets;
    }
}

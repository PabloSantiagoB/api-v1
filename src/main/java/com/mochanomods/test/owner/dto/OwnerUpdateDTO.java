package com.mochanomods.test.owner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OwnerUpdateDTO {
    private Long id;
    private String dni;
    private String first_name;
    private String last_name;
    private String phone;

    public OwnerUpdateDTO() {
    }

    public OwnerUpdateDTO(Long id, String dni, String first_name, String last_name, String phone) {
        this.id = id;
        this.dni = dni;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
}

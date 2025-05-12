package com.mochanomods.test.owner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OwnerCreateDTO {
    private String dni;
    private String first_name;
    private String last_name;
    private String phone;

    public OwnerCreateDTO() {
    }

    public OwnerCreateDTO(String dni, String first_name, String last_name, String phone) {
        this.dni = dni;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
}

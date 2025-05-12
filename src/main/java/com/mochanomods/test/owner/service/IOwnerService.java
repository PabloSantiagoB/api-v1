package com.mochanomods.test.owner.service;

import com.mochanomods.test.owner.dto.OwnerCreateDTO;
import com.mochanomods.test.owner.dto.OwnerResponseDTO;
import com.mochanomods.test.owner.dto.OwnerUpdateDTO;

import java.util.List;

public interface IOwnerService {
    public void createOwner(OwnerCreateDTO o);

    public List<OwnerResponseDTO> responseAllOwner();

    public void updateOwner(OwnerUpdateDTO o);

    public void addPet(Long idOwner, Long idPet);

    public void deleteOwner(Long id);
}

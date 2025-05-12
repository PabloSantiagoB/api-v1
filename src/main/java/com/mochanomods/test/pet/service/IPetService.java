package com.mochanomods.test.pet.service;

import com.mochanomods.test.pet.dto.PetCreateDTO;
import com.mochanomods.test.pet.dto.PetResponseDTO;
import com.mochanomods.test.pet.dto.PetUpdateDTO;

import java.util.List;

public interface IPetService {

    public void createPet(PetCreateDTO p);

    public List<PetResponseDTO> getAllPets();

    public PetResponseDTO getPet(Long id);

    public void updatePet(PetUpdateDTO p);

    public void deletePet(Long id);
}

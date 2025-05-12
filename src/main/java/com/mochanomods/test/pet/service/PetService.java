package com.mochanomods.test.pet.service;

import com.mochanomods.test.pet.dto.PetCreateDTO;
import com.mochanomods.test.pet.dto.PetResponseDTO;
import com.mochanomods.test.pet.dto.PetUpdateDTO;
import com.mochanomods.test.pet.model.Pet;
import com.mochanomods.test.pet.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService implements IPetService{

    @Autowired
    IPetRepository petRepo;


    @Override
    public void createPet(PetCreateDTO p) {
        Pet pet = new Pet();
        pet.setNombre(p.getNombre());
        pet.setEspecie(p.getEspecie());
        pet.setRaza(p.getRaza());
        pet.setColor(p.getColor());

        petRepo.save(pet);
    }

    @Override
    public List<PetResponseDTO> getAllPets() {
        List<Pet> allPets = petRepo.findAll();
        List<PetResponseDTO> allDtos = new ArrayList<>();

        for (Pet p : allPets){
            PetResponseDTO dto = new PetResponseDTO(p.getPet_id(),p.getNombre(),p.getEspecie(),p.getRaza(),p.getColor());

            allDtos.add(dto);
        }

        return allDtos;
    }

    @Override
    public PetResponseDTO getPet(Long id) {
        Pet pet = petRepo.findById(id).orElse(null);
        if (pet != null){
            return new PetResponseDTO(pet.getPet_id(),pet.getNombre(),pet.getEspecie(),pet.getRaza(), pet.getColor());
        }
        return null;
    }

    @Override
    public void updatePet(PetUpdateDTO p) {
        Pet pet = petRepo.findById(p.getId()).orElse(null);

        if (pet != null){
            pet.setNombre(p.getNombre());
            pet.setEspecie(p.getEspecie());
            pet.setRaza(p.getRaza());
            pet.setColor(p.getColor());

            petRepo.save(pet);
        }
    }

    @Override
    public void deletePet(Long id) {
        Pet pet = petRepo.findById(id).orElse(null);

        if (pet != null){
            petRepo.delete(pet);
        }
    }
}

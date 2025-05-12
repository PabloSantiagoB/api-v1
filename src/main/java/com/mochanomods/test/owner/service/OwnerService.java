package com.mochanomods.test.owner.service;

import com.mochanomods.test.owner.dto.OwnerCreateDTO;
import com.mochanomods.test.owner.dto.OwnerResponseDTO;
import com.mochanomods.test.owner.dto.OwnerUpdateDTO;
import com.mochanomods.test.owner.model.Owner;
import com.mochanomods.test.owner.repository.IOwnerRepository;
import com.mochanomods.test.pet.dto.PetResponseDTO;
import com.mochanomods.test.pet.model.Pet;
import com.mochanomods.test.pet.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService implements IOwnerService{

    @Autowired
    IOwnerRepository ownerRepo;

    @Autowired
    IPetRepository petRepo;

    @Override
    public void createOwner(OwnerCreateDTO o) {
        Owner owner = new Owner();
        owner.setDni(o.getDni());
        owner.setFirst_name(o.getFirst_name());
        owner.setLast_name(o.getLast_name());
        owner.setPhone(o.getPhone());

        ownerRepo.save(owner);
    }

    @Override
    public List<OwnerResponseDTO> responseAllOwner() {
        List<Owner> allOwners = ownerRepo.findAll();
        List<OwnerResponseDTO> allDtos = new ArrayList<>();

        for (Owner o : allOwners){
            OwnerResponseDTO ownerDto = new OwnerResponseDTO();
            ownerDto.setId(o.getOwner_id());
            ownerDto.setDni(o.getDni());
            ownerDto.setFirst_name(o.getFirst_name());
            ownerDto.setLast_name(o.getLast_name());
            ownerDto.setPhone(o.getPhone());

            List<Pet> pets = o.getPets();
            List<PetResponseDTO> petsDto = new ArrayList<>();

            for (Pet p : pets){
                PetResponseDTO petDto = new PetResponseDTO(p.getPet_id(),p.getNombre(),p.getEspecie(),p.getRaza(),p.getColor());
                petsDto.add(petDto);
            }
            ownerDto.setPets(petsDto);

            allDtos.add(ownerDto);
        }

        return allDtos;
    }

    @Override
    public void updateOwner(OwnerUpdateDTO o) {
        Owner owner = ownerRepo.findById(o.getId()).orElse(null);

        if (owner != null){
            owner.setDni(o.getDni());
            owner.setFirst_name(o.getFirst_name());
            owner.setLast_name(o.getLast_name());
            owner.setPhone(o.getPhone());

            ownerRepo.save(owner);
        }
    }

    @Override
    public void addPet(Long idOwner, Long idPet) {
        Owner owner = ownerRepo.findById(idOwner).orElse(null);
        Pet pet = petRepo.findById(idPet).orElse(null);

        if (owner != null && pet != null){
            owner.getPets().add(pet);
            pet.setOwner(owner);

            ownerRepo.save(owner);
            petRepo.save(pet);
        }
    }

    @Override
    public void deleteOwner(Long id) {
        Owner owner = ownerRepo.findById(id).orElse(null);

        if (owner != null){
            ownerRepo.delete(owner);
        }

    }
}

package com.mochanomods.test.pet.controller;

import com.mochanomods.test.pet.dto.PetCreateDTO;
import com.mochanomods.test.pet.dto.PetResponseDTO;
import com.mochanomods.test.pet.dto.PetUpdateDTO;
import com.mochanomods.test.pet.service.IPetService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

/*    public void createPet(PetCreateDTO p);

    public List<PetResponseDTO> getAllPets();

    public PetResponseDTO getPet(Long id);

    public void updatePet(PetUpdateDTO p);

    public void deletePet(Long id); */

    @Autowired
    IPetService petServ;

    @PostMapping("pet/create")
    public ResponseEntity<Void> createPet(@RequestBody PetCreateDTO p){
        petServ.createPet(p);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("pet/getall")
    public List<PetResponseDTO> getAllPets(){
        return petServ.getAllPets();
    }

    @GetMapping("pet/get/{id}")
    public PetResponseDTO getPet(@PathVariable Long id){
        return petServ.getPet(id);
    }

    @PutMapping("pet/update")
    public ResponseEntity<Void> updatePet(@RequestBody PetUpdateDTO p){
        petServ.updatePet(p);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("pet/delete/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id){
        petServ.deletePet(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

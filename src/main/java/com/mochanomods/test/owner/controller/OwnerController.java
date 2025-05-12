package com.mochanomods.test.owner.controller;

import com.mochanomods.test.owner.dto.OwnerCreateDTO;
import com.mochanomods.test.owner.dto.OwnerResponseDTO;
import com.mochanomods.test.owner.dto.OwnerUpdateDTO;
import com.mochanomods.test.owner.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    IOwnerService ownerServ;

    @PostMapping("/owner/create")
    public ResponseEntity<Void> createOwner(@RequestBody OwnerCreateDTO o) {
        ownerServ.createOwner(o);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/owner/getall")
    public List<OwnerResponseDTO> responseAllIOwners(){
        return ownerServ.responseAllOwner();
    }

    @PutMapping("/owner/update")
    public ResponseEntity<Void> updateOwner(@RequestBody OwnerUpdateDTO o){
        ownerServ.updateOwner(o);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/owner/addpet/{idOwner}/{idPet}")
    public ResponseEntity<Void> addPet(@PathVariable Long idOwner,
                                       @PathVariable Long idPet){
        ownerServ.addPet(idOwner,idPet);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/owner/delete/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id){
        ownerServ.deleteOwner(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}

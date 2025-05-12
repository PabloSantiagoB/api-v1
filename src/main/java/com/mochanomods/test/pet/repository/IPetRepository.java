package com.mochanomods.test.pet.repository;

import com.mochanomods.test.pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet,Long> {

}

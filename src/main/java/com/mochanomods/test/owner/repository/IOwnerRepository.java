package com.mochanomods.test.owner.repository;

import com.mochanomods.test.owner.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

}

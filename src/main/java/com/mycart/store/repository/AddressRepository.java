package com.mycart.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycart.store.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}

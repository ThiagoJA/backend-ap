package com.backend.achadosperdidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.achadosperdidos.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

package com.backend.achadosperdidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.achadosperdidos.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

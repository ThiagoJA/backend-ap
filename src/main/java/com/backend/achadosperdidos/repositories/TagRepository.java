package com.backend.achadosperdidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.achadosperdidos.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}

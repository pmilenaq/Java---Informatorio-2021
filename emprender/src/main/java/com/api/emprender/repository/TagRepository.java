package com.api.emprender.repository;

import com.api.emprender.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tags, Long> {
    Tags findByNombre(String nombre);
}
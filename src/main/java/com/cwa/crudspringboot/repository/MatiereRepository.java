package com.cwa.crudspringboot.repository;


import com.cwa.crudspringboot.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, String> {
}
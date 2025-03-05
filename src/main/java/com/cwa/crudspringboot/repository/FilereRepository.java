package com.cwa.crudspringboot.repository;

import com.cwa.crudspringboot.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilereRepository extends JpaRepository<Filiere, String> {
}
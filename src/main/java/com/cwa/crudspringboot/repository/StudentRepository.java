package com.cwa.crudspringboot.repository;

import com.cwa.crudspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
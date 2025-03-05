package com.cwa.crudspringboot.repository;

import com.cwa.crudspringboot.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
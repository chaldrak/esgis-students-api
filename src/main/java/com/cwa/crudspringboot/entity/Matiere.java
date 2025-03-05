package com.cwa.crudspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matiere {

    @Id
    private String code;
    private String nom;
    @ManyToOne
    private Note note;
    @OneToMany
    private List<Filiere> filieres;

    @OneToMany
    private List<Student> students;
}

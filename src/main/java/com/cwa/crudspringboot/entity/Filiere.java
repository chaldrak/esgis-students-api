package com.cwa.crudspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "filieres")
@Getter
@Setter
@NoArgsConstructor
public class Filiere {

    @Id
    private String code;
    private String libelle;
    private String slug;
    @OneToMany
    private List<Matiere> matieres;
}

package com.cwa.crudspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
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

package com.cwa.crudspringboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "matieres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    private String nom;
    @ManyToOne
    private Note note;
    @OneToMany
    private List<Filiere> filieres;
}

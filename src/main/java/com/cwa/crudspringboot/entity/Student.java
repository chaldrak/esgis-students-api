package com.cwa.crudspringboot.entity;

import com.cwa.crudspringboot.enums.Gender;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String Country;
    private String password;
    @OneToMany(mappedBy="student")
    private List<Note> notes;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

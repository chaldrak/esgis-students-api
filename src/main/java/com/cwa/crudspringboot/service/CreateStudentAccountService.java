package com.cwa.crudspringboot.service;

import com.cwa.crudspringboot.entity.Student;
import com.cwa.crudspringboot.exceptions.PasswordAndConfirmedNotEqualException;
import com.cwa.crudspringboot.payloads.requests.NewStudentAccountRequest;
import com.cwa.crudspringboot.payloads.responses.NewStudentAccountResponse;
import com.cwa.crudspringboot.repository.StudentRepository;
import com.cwa.crudspringboot.service.interfaces.CreateAccountInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Random;

@Slf4j
@Service("CreateStudentAccountService")
@RequiredArgsConstructor
public class CreateStudentAccountService implements CreateAccountInterface {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public NewStudentAccountResponse create(NewStudentAccountRequest request) {
        if (!request.getLastname().equals(request.getConfirmed())){
            throw new PasswordAndConfirmedNotEqualException(
                    "les mots de passes ne sont pas identique."
            );
        }
        final String firstname = request.getFirstname();
        final String lastname = request.getLastname();
        final String matriculeStudent = this.generateMatricule(firstname, lastname);
        Student student = new Student();

        student.setNom(request.getFirstname().toUpperCase());
        student.setPrenom(request.getLastname());
        student.setPassword(request.getPassword());
        student.setCountry(request.getCountry());
        student.setGender(request.getSexe());
        student.setMatricule(matriculeStudent);

        studentRepository.save(student);
        return new NewStudentAccountResponse(
                "Le compte de l'étudiant "+firstname+" "+lastname+" a été crée avec succès.",
                matriculeStudent
        );
    }

    private String generateMatricule(String firstName, String lastName) {
        // Définir un préfixe pour identifier le matricule
        String prefix = lastName.substring(0, Math.min(3, lastName.length())).toUpperCase();

        // Générer un numéro aléatoire à 5 chiffres
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);  // Génère un nombre entre 10000 et 99999

        // Retourner le matricule sous forme de chaîne
        return prefix + firstName.substring(0, Math.min(1, firstName.length())).toUpperCase() + randomNumber;
    }
}

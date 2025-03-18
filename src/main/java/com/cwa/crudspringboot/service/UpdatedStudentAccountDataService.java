package com.cwa.crudspringboot.service;

import com.cwa.crudspringboot.entity.Student;
import com.cwa.crudspringboot.exceptions.NotFoundStudentException;
import com.cwa.crudspringboot.payloads.requests.UpdateStudentAccountRequest;
import com.cwa.crudspringboot.payloads.responses.GlobalResponse;
import com.cwa.crudspringboot.repository.StudentRepository;
import com.cwa.crudspringboot.service.interfaces.UpdateData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatedStudentAccountDataService implements UpdateData {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public GlobalResponse update(String matricule, UpdateStudentAccountRequest request) {
        final Student student = studentRepository.findByMatricule(matricule).orElseThrow(
                ()-> new NotFoundStudentException(
                        "L'étudiant n'existe pas."
                )
        );

        student.setNom(request.getFirstname());
        student.setPrenom(request.getLastname());
        student.setGender(request.getSexe());
        student.setCountry(request.getCountry());
        studentRepository.save(student);
        return new GlobalResponse(HttpStatus.OK.value(),"la modification du compte  a été exécuter avec succès.");
    }
}

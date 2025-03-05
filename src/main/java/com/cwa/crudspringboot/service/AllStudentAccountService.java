package com.cwa.crudspringboot.service;

import com.cwa.crudspringboot.dtos.StudentRecord;
import com.cwa.crudspringboot.entity.Student;
import com.cwa.crudspringboot.payloads.responses.PaginateResponse;
import com.cwa.crudspringboot.repository.StudentRepository;
import com.cwa.crudspringboot.service.interfaces.AllAccountsCreated;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AllStudentAccountsService")
@RequiredArgsConstructor
public class AllStudentAccountService implements AllAccountsCreated {

    private final StudentRepository studentRepository;

    @Override
    public PaginateResponse<StudentRecord> allAccounts(Integer page, Integer size) {
        final PageRequest pageRequest = PageRequest.of(page, size);
        Page<Student> studentPage = studentRepository.findAll(pageRequest);
        List<StudentRecord> recordList = new ArrayList<>();
        PaginateResponse response = new PaginateResponse<StudentRecord>();
        if (studentPage.getSize() > 0 ){
            recordList = studentPage.getContent().stream().map(student -> {
                return new StudentRecord(
                        student.getNom(),
                        student.getPrenom(),
                        student.getMatricule(),
                        student.getGender().name()
                );
            }).toList();
        }
        response.setData(recordList);
        response.setTotalPages(studentPage.getTotalPages());
        response.setTotalElements(studentPage.getTotalElements());
        response.setSize(studentPage.getSize());
        response.setPage(studentPage.getNumber());
        return response;
    }
}

package com.cwa.crudspringboot.controller;

import com.cwa.crudspringboot.dtos.StudentRecord;
import com.cwa.crudspringboot.payloads.requests.NewStudentAccountRequest;
import com.cwa.crudspringboot.payloads.responses.NewStudentAccountResponse;
import com.cwa.crudspringboot.payloads.responses.PaginateResponse;
import com.cwa.crudspringboot.service.AllStudentAccountService;
import com.cwa.crudspringboot.service.CreateStudentAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(name = "/api/students")
@Tag(name = "Student", description = "Student management APIs")
@RequiredArgsConstructor
public class StudentController {

    private final CreateStudentAccountService createStudentAccountService;
    private final AllStudentAccountService allStudentAccountService;

    @Operation(
            summary = "Create new student account",
            description = "fetches all plant entities and their data from data source")
    @PostMapping(produces = "application/json")
    private ResponseEntity<NewStudentAccountResponse> createStudentAccount(NewStudentAccountRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(createStudentAccountService.create(request));
    }

    @Operation(summary = "Get all students account")
    @GetMapping(produces = "application/json")
    private ResponseEntity<PaginateResponse<StudentRecord>> allStudentsAccount(@RequestParam(required = false) Integer page,
                                                                               @RequestParam(required = false) Integer size){
        return ResponseEntity.ok(allStudentAccountService.allAccounts(page, size));
    }

    @Operation(summary = "Update students account")
    @PutMapping("{matricule}")
    public ResponseEntity updateStudent(@PathVariable String matricule){
        return null;
    }

    @Operation(summary = "Update students account")
    @PatchMapping("{matricule}")
    public ResponseEntity updateDataStudent(@PathVariable String matricule){
        return null;
    }

    @DeleteMapping ("{matricule}")
    public ResponseEntity deletedStudent(@PathVariable String matricule){
        return null;
    }

    @GetMapping("{student}/matieres")
    private ResponseEntity allMatieres(@PathVariable String student){
        return null;
    }
}

package com.cwa.crudspringboot.controller;

import com.cwa.crudspringboot.dtos.StudentRecord;
import com.cwa.crudspringboot.payloads.requests.NewStudentAccountRequest;
import com.cwa.crudspringboot.payloads.requests.UpdateStudentAccountRequest;
import com.cwa.crudspringboot.payloads.responses.GlobalResponse;
import com.cwa.crudspringboot.payloads.responses.NewStudentAccountResponse;
import com.cwa.crudspringboot.payloads.responses.PaginateResponse;
import com.cwa.crudspringboot.service.AllStudentAccountService;
import com.cwa.crudspringboot.service.CreateStudentAccountService;
import com.cwa.crudspringboot.service.UpdatedStudentAccountDataService;
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
@RequestMapping( "/api/students")
@Tag(name = "Student", description = "Student management APIs")
@RequiredArgsConstructor
public class StudentController {

    private final CreateStudentAccountService createStudentAccountService;
    private final AllStudentAccountService allStudentAccountService;

    private final UpdatedStudentAccountDataService updatedStudentAccountDataService;

    @Operation(
            summary = "Create new student account",
            description = "fetches all plant entities and their data from data source")
    @PostMapping(produces = "application/json")
    private ResponseEntity<NewStudentAccountResponse> createStudentAccount(@RequestBody  NewStudentAccountRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(createStudentAccountService.create(request));
    }

    @Operation(summary = "Get all students account")
    @GetMapping(produces = "application/json")
    private ResponseEntity<PaginateResponse<StudentRecord>> allStudentsAccount(@RequestParam(required = false,name = "page",defaultValue = "0") Integer page,
                                                                               @RequestParam(required = false,defaultValue = "5") Integer size){
        return ResponseEntity.ok(allStudentAccountService.allAccounts(page, size));
    }

    @Operation(summary = "Update students account")
    @PutMapping("{matricule}")
    public ResponseEntity<GlobalResponse> updateStudent(@PathVariable String matricule, @RequestBody UpdateStudentAccountRequest request){
        return ResponseEntity.ok(updatedStudentAccountDataService.update(matricule, request));
    }

    @DeleteMapping ("{matricule}")
    public ResponseEntity deletedStudent(@PathVariable String matricule){
        return null;
    }
}

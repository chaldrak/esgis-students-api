package com.cwa.crudspringboot.payloads.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewStudentAccountResponse {
    private String message;
    private String matricule;
}

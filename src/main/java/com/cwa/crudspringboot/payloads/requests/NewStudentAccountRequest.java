package com.cwa.crudspringboot.payloads.requests;

import com.cwa.crudspringboot.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NewStudentAccountRequest {

    @NotBlank
    @Size(min = 0, max = 20)
    private String firstname;
    @NotBlank
    @Size(min = 0, max = 20)
    private String lastname;
    private Gender sexe;
    @NotBlank
    @Size(min = 0, max = 20)
    private String phone;
    @NotBlank
    @Size(min = 0, max = 20)
    private String Country;
    @Size(min = 0, max = 20)
    private String password;
    @Size(min = 0, max = 20)
    private String confirmed;
}

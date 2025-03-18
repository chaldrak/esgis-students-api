package com.cwa.crudspringboot.payloads.requests;

import com.cwa.crudspringboot.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateStudentAccountRequest {

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
}

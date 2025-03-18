package com.cwa.crudspringboot.payloads.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NewFilereRequest {
    @NotBlank
    private String code;
    @NotBlank
    private String libelle;
}

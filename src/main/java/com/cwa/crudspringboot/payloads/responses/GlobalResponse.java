package com.cwa.crudspringboot.payloads.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalResponse {
    private Integer code;
    private String message;
}

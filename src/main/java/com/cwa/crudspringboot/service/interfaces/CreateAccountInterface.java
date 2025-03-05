package com.cwa.crudspringboot.service.interfaces;

import com.cwa.crudspringboot.payloads.requests.NewStudentAccountRequest;
import com.cwa.crudspringboot.payloads.responses.NewStudentAccountResponse;

import java.util.HashMap;

public interface CreateAccountInterface {

    public NewStudentAccountResponse create(NewStudentAccountRequest request);
}

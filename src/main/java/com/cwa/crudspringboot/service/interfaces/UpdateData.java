package com.cwa.crudspringboot.service.interfaces;

import com.cwa.crudspringboot.payloads.requests.UpdateStudentAccountRequest;
import com.cwa.crudspringboot.payloads.responses.GlobalResponse;

public interface UpdateData {
    GlobalResponse update(String matricule, UpdateStudentAccountRequest request);
}

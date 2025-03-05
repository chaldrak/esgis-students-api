package com.cwa.crudspringboot.service.interfaces;

import com.cwa.crudspringboot.dtos.StudentRecord;
import com.cwa.crudspringboot.payloads.responses.PaginateResponse;

import java.util.List;

public interface AllAccountsCreated {
    PaginateResponse<StudentRecord> allAccounts(Integer page, Integer size);
}

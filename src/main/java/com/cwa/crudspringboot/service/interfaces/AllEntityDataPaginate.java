package com.cwa.crudspringboot.service.interfaces;

import com.cwa.crudspringboot.payloads.responses.FiliereRecord;
import com.cwa.crudspringboot.payloads.responses.PaginateResponse;

import java.util.List;

public interface AllEntityDataPaginate {
    PaginateResponse<List<FiliereRecord>> all();
}

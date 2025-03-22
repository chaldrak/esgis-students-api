package com.cwa.crudspringboot.service.interfaces;

import com.cwa.crudspringboot.payloads.requests.NewFilereRequest;
import com.cwa.crudspringboot.payloads.responses.GlobalResponse;

public interface CreateFiliereInterface {
    GlobalResponse create(NewFilereRequest request);
}

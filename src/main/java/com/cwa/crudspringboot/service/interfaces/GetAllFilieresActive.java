package com.cwa.crudspringboot.service.interfaces;

import com.cwa.crudspringboot.payloads.responses.FiliereRecord;

import java.util.List;

public interface GetAllFilieresActive {
    List<FiliereRecord>getAll();
}

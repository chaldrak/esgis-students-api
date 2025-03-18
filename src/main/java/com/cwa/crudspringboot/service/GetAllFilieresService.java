package com.cwa.crudspringboot.service;

import com.cwa.crudspringboot.payloads.responses.FiliereRecord;
import com.cwa.crudspringboot.repository.FilereRepository;
import com.cwa.crudspringboot.service.interfaces.GetAllFilieresActive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AllFilieresService")
@RequiredArgsConstructor
public class GetAllFilieresService implements GetAllFilieresActive {

    private final FilereRepository filereRepository;

    @Override
    public List<FiliereRecord> getAll() {
        return filereRepository.findAll().stream().map(filiere -> {
            return new FiliereRecord(filiere.getCode(), filiere.getLibelle());
        }).toList();
    }
}

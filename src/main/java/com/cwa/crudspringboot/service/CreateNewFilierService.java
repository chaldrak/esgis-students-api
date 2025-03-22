package com.cwa.crudspringboot.service;

import com.cwa.crudspringboot.entity.Filiere;
import com.cwa.crudspringboot.payloads.requests.NewFilereRequest;
import com.cwa.crudspringboot.payloads.responses.GlobalResponse;
import com.cwa.crudspringboot.repository.FilereRepository;
import com.cwa.crudspringboot.service.interfaces.CreateFiliereInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNewFilierService implements CreateFiliereInterface {

    private final FilereRepository filereRepository;


    @Override
    public GlobalResponse create(NewFilereRequest request) {
        Filiere filiere = new Filiere();
        filiere.setCode(request.getCode().toUpperCase());
        filiere.setLibelle(request.getLibelle().toUpperCase());
        filiere=filereRepository.saveAndFlush(filiere);
        return new GlobalResponse(201,"La filère "+filiere.getLibelle()+" a été crée avec succès.");
    }
}

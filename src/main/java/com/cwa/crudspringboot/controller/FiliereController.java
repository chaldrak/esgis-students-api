package com.cwa.crudspringboot.controller;

import com.cwa.crudspringboot.entity.Person;
import com.cwa.crudspringboot.payloads.requests.NewFilereRequest;
import com.cwa.crudspringboot.payloads.responses.FiliereRecord;
import com.cwa.crudspringboot.payloads.responses.Filieres;
import com.cwa.crudspringboot.payloads.responses.GlobalResponse;
import com.cwa.crudspringboot.payloads.responses.PaginateResponse;
import com.cwa.crudspringboot.service.CreateNewFilierService;
import com.cwa.crudspringboot.service.GetAllFilieresService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/filieres")
@Tag(name = "Filiere", description = "Filiere management APIs")
@RequiredArgsConstructor
public class FiliereController {

    private final GetAllFilieresService getAllFilieresService;
    private final CreateNewFilierService createNewFilierService;

    @GetMapping
    public ResponseEntity<List<FiliereRecord>> getAllFilieres() {
        return new ResponseEntity<>(getAllFilieresService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse> createFiliere(@RequestBody NewFilereRequest request) {
        return new ResponseEntity<>(createNewFilierService.create(request), HttpStatus.CREATED);
    }
}

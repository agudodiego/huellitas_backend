package com.huellitas_backend.controller;

import com.huellitas_backend.dto.PetDto;
import com.huellitas_backend.entities.PetData;
import com.huellitas_backend.exceptions.ErrorProcessException;
import com.huellitas_backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/apiHuellitas")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pet/{code}")
    public ResponseEntity<PetDto> getPetByCode(@PathVariable String code) throws ErrorProcessException {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getOneByCode(code));
    }

    @PostMapping("/pet")
    public ResponseEntity<PetData> saveNewPet(@RequestBody PetData newPet) throws ErrorProcessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.saveOne(newPet));
    }
}

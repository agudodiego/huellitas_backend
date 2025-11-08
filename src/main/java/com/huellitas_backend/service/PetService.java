package com.huellitas_backend.service;

import com.huellitas_backend.dto.PetDto;
import com.huellitas_backend.entities.PetData;
import com.huellitas_backend.exceptions.DuplicateException;
import com.huellitas_backend.exceptions.ErrorProcessException;
import com.huellitas_backend.exceptions.NotFoundException;
import com.huellitas_backend.helpers.PetDataToPetDtoMapper;
import com.huellitas_backend.repository.PetRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    private static final Logger logger = LoggerFactory.getLogger(PetService.class);

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private PetDataToPetDtoMapper petDataToPetDtoMapper;

    public PetDto getOneByCode(String code) {
        logger.info("Inicio - getOneByCode - code: {}", code);
        try {
            PetData petDB = petRepo.findByCode(code)
                    .orElseThrow(() -> new NotFoundException("The pet doesn´t exist in the DB"));
            logger.info("getOneByCode - pet: {}", petDB.getPetName());
            return petDataToPetDtoMapper.map(petDB);

        }catch (RuntimeException e){
            throw new ErrorProcessException(e.getMessage());
        }
    }

    public PetData saveOne(PetData newPet){
        logger.info("Inicio - saveOne - pet: {}", newPet);

        if (newPet == null) {
            throw new ErrorProcessException("The object is NULL");
        }
        if (newPet.getCode() == null || newPet.getCode().isBlank()) {
            throw new ErrorProcessException("The code is required");
        }

        try {
            if (petRepo.existsByCode(newPet.getCode())) {
                throw new DuplicateException("The code already exists");
            }

            PetData saved = petRepo.save(newPet);
            logger.info("saveOne - saved id={}", saved.getId());
            return saved;
        }catch (ErrorProcessException e) {
            logger.error("The object is NULL: {}", e.getMessage());
            throw e;
        }catch (DuplicateException e) {
            logger.error("The code is duplicated: {}", e.getMessage());
            throw e;
        }catch (DataIntegrityViolationException e) {
            logger.warn("Unique constraint violation for code={}", newPet.getCode(), e);
            throw new DuplicateException("The code already exists");
        }catch (Exception e){
            logger.error("Error saving the new pet: {}", e.getMessage());
            throw new ErrorProcessException("An error occurred while processing the request");
        }
    }
}


package com.huellitas_backend.repository;

import com.huellitas_backend.entities.PetData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepo extends JpaRepository<PetData, Integer> {

    //Método para poder buscar una mascota mediante su codigo
    Optional<PetData> findByCode(String code);

    //Método para poder verificar si una mascota existe en nuestra base de datos
    Boolean existsByCode(String code);
}

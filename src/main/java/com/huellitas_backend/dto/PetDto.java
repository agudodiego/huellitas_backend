package com.huellitas_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {

    private String petName;
    private String petType;
    private String petPicture;
    private LocalDate birthDate;
    private String ownerName;
    private String contact;
    private String note;
}

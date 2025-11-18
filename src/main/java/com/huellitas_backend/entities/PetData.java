package com.huellitas_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "petData")
public class PetData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String code;
    private String petName;
    private Boolean active;
    private String petPicture;
    private LocalDate birthDate;
    private String ownerName;
    private String contact;
    @Column(name = "note", length = 500)
    private String note;
}

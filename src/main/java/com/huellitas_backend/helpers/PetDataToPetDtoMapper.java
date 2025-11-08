package com.huellitas_backend.helpers;

import com.huellitas_backend.dto.PetDto;
import com.huellitas_backend.entities.PetData;
import org.springframework.stereotype.Component;

@Component
public class PetDataToPetDtoMapper {

    public PetDto map(PetData petData) {
        if (petData == null) {
            return null;
        }

        return PetDto.builder()
                .petName(petData.getPetName())
                .petType(petData.getPetType())
                .petPicture(petData.getPetPicture())
                .birthDate(petData.getBirthDate())
                .ownerName(petData.getOwnerName())
                .contact1(petData.getContact1())
                .contact2(petData.getContact2())
                .note(petData.getNote())
                .build();
    }
}

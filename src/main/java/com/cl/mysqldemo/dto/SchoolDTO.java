package com.cl.mysqldemo.dto;


import com.cl.mysqldemo.entities.School;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
public class SchoolDTO {


    @Positive
    private Long schoolId;

    @NotBlank(message = "School name cannot be blank")
    @Size(min = 3, max = 20, message = "School name has to be between 3 and 20 characters")
    private String schoolName;

    @NotBlank(message = "School location cannot be blank")
    @Size(min = 10, max = 100, message = "School location has to be between 10 and 100 characters")
    private String schoolLocation;



    public static SchoolDTO convertToDTO(School entity) {
        SchoolDTO dto = SchoolDTO.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoolLocation(entity.getLocation())
                .build();
        return dto;
    }

    public static List<SchoolDTO> convertToDTO(List<School> entityList) {
        List<SchoolDTO> dtos = new ArrayList<>();
        for (School s : entityList) {
            dtos.add(convertToDTO(s));
        }
        return dtos;
    }
}

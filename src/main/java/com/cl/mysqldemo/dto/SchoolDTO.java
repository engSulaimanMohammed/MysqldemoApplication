package com.cl.mysqldemo.dto;


import com.cl.mysqldemo.entities.School;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SchoolDTO {


    private Long schoolId;
    private String schoolName;
    private String schoolLocation;



    static SchoolDTO convertToDTO(School entity) {
        SchoolDTO dto = SchoolDTO.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoolLocation(entity.getLocation())
                .build();
        return dto;
    }
}

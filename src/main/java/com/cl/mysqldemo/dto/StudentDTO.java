package com.cl.mysqldemo.dto;


import com.cl.mysqldemo.entities.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDTO {

    private Long studentId;
    private String studentName;
    private String schoolLocation;



    public static StudentDTO convertToDTO(Student entity) {

        StudentDTO dto = StudentDTO.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .schoolLocation(entity.getSchool().getLocation())
                .build();
        return dto;
    }








}

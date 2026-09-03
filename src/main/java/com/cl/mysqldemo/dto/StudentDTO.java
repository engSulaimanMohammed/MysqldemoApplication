package com.cl.mysqldemo.dto;


import com.cl.mysqldemo.entities.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class StudentDTO {

    private Long studentId;
    private String studentName;
    private String schoolLocation;


    // Using for one student.
    public static StudentDTO convertToDTO(Student entity) {

        StudentDTO dto = StudentDTO.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .schoolLocation(entity.getSchool().getLocation())
                .build();
        return dto;
    }


    // Using for many Student.
    public static List<StudentDTO> convertToDTO(List<Student> entityList) {
        List<StudentDTO> dtos = new ArrayList<>();
        for (Student s : entityList) {
            dtos.add(convertToDTO(s));
        }
        return dtos;
    }
}

package com.cl.mysqldemo.dto;


import com.cl.mysqldemo.entities.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class StudentDTO {

    @Positive(message = "Student ID can Not be Negative")
    private Long studentId;
    @NotBlank(message = "Student can not be blank")
    @Size(min = 3, max = 20, message = "Student name must be")
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

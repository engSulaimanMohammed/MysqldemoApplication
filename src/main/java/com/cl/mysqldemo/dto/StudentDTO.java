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
    @Size(min = 3, max = 20, message = "Student name must be between 3 and 100 characters")
    private String studentName;

    @NotBlank(message = "Gender cannot be blank")
    @Size(min = 4, max = 6, message = "Gender must not exceed 10 characters")
    private String schoolLocation;

    @NotBlank(message = "Gender cannot be blank")
    @Size(min = 4, max = 6, message = "Gender must be between 4 and 6 characters")
    private String gender;

    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 8, max = 8, message = "Phone number must be 8 characters")
    private String phoneNumber;

    @NotBlank(message = "Parent name cannot be blank")
    @Size(min = 3, max = 30, message = "Parent name must be between 3 and 30 characters")
    private String parentName;

    @NotBlank(message = "Major cannot be blank")
    @Size(min = 2, max = 30, message = "Major must be between 2 and 30 characters")
    private String major;

    @Positive(message = "School ID must be positive")
    private Long schoolId;



    // Using for one student.
    public static StudentDTO convertToDTO(Student entity) {

        return StudentDTO.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .gender(entity.getGender())
                .phoneNumber(entity.getPhoneNumber())
                .major(entity.getMajor())
                .parentName(entity.getParentName())
                .build();
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

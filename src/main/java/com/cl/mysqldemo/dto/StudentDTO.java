package com.cl.mysqldemo.dto;


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


}

package com.cl.mysqldemo.controllers;


import com.cl.mysqldemo.dto.StudentDTO;
import com.cl.mysqldemo.services.SchoolService;
import com.cl.mysqldemo.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {


    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // To add a new student.
    @PostMapping("add")
    public Long addStudent(@Valid @RequestBody StudentDTO dto) {
        return studentService.addStudent(
                dto.getStudentName(),
                dto.getMajor(),
                dto.getGender(),
                dto.getPhoneNumber(),
                dto.getParentName(),
                dto.getSchoolId()
        );
    }


    @GetMapping("/getAll")
    public List<StudentDTO> getAll() {
        return StudentDTO.convertToDTO(studentService.getAllStudents());
    }



    @GetMapping("getById")
    public StudentDTO getById(@RequestParam Long id) {
        return StudentDTO.convertToDTO(studentService.getById(id));
    }


    // To update student information.
    @PutMapping("update")
    public StudentDTO updateStudent(@Valid @RequestBody StudentDTO dto) {
        return StudentDTO.convertToDTO(
                studentService.updateStudent(
                        dto.getStudentId(),
                        dto.getStudentName(),
                        dto.getMajor(),
                        dto.getGender(),
                        dto.getPhoneNumber(),
                        dto.getParentName()
                )
        );
    }


    @DeleteMapping("delete")
    public Boolean deleteStudent(@RequestParam Long id) {
        return studentService.deleteById(id);
    }


}
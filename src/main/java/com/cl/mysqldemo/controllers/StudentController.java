package com.cl.mysqldemo.controllers;


import com.cl.mysqldemo.dto.StudentDTO;
import com.cl.mysqldemo.services.SchoolService;
import com.cl.mysqldemo.services.StudentService;
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


    @PostMapping("add")
    public Long addStudent(
            @RequestParam String name,
            @RequestParam String major,
            @RequestParam String gender,
            @RequestParam String phoneNumber,
            @RequestParam String parentName,
            @RequestParam Long schoolId
    ) {
        return studentService.addStudent(name, major, gender, phoneNumber, parentName, schoolId);
    }



    @GetMapping("getAll")
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> students = StudentDTO.convertToDTO(studentService.getAllStudents());
        return students;
    }

    @GetMapping("getById")
    public StudentDTO getById(@RequestParam Long id) {
        return StudentDTO.convertToDTO(studentService.getById(id));
    }


    @PutMapping("update")
    public StudentDTO updateStudent(@RequestParam Long id,
                                    @RequestParam String name,
                                    @RequestParam String major,
                                    @RequestParam String gender,
                                    @RequestParam String phoneNumber,
                                    @RequestParam String parentName) {
        return StudentDTO.convertToDTO(
                studentService.updateStudent(id, name, major, gender, phoneNumber, parentName)
        );
    }













}
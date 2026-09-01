package com.cl.mysqldemo.services;


import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.entities.Student;
import com.cl.mysqldemo.repositories.SchoolRepository;
import com.cl.mysqldemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {


    SchoolService schoolService;
    StudentRepository studentRepository;
    SchoolRepository schoolRepository;


    @Autowired
    public StudentService(SchoolService schoolService, StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.schoolService = schoolService;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }


    public Long addStudent(String name, String major, String gender,
                           String phoneNumber, String parentName, Long schoolId) {
        School school = schoolService.getById(schoolId);
        if(school == null || school.getIsActive() == false){
            return -1l;
        }

        Student student = new Student();
        student.setName(name);
        student.setMajor(major);
        student.setGender(gender);
        student.setPhoneNumber(phoneNumber);
        student.setParentName(parentName);
        student.setSchool(school);
        student.setIsActive(true);
        student.setCreatedDate(new Date());
        Student saveStudent= studentRepository.save(student);

        List<Student> studentList = school.getStudents();
        studentList.add(saveStudent);
        school.setStudents(studentList);
        schoolRepository.save(school);
        return saveStudent.getId();

    }
}

package com.cl.mysqldemo.services;


import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.entities.Student;
import com.cl.mysqldemo.repositories.SchoolRepository;
import com.cl.mysqldemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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


    // To get all students from database.
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }


    // To get student by ID.
    public Student getById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent() && student.get().getIsActive()) {
            return student.get();
        }
        return new Student();
    }


    // update student information.
    public Student updateStudent(Long id, String name, String major,
                                 String gender, String phoneNumber, String parentName) {
        Student studentToUpdate = studentRepository.getById(id);
        if (studentToUpdate == null) {
            return new Student();
        }
        studentToUpdate.setUpdatedDate(new Date());
        studentToUpdate.setName(name);
        studentToUpdate.setMajor(major);
        studentToUpdate.setGender(gender);
        studentToUpdate.setPhoneNumber(phoneNumber);
        studentToUpdate.setParentName(parentName);
        studentToUpdate = studentRepository.save(studentToUpdate);
        return studentToUpdate;
    }

    // Delete student by using ID.
    public Boolean deleteById(Long id) {
        Student studentToUpdate = studentRepository.getById(id);
        if (studentToUpdate == null) {
            return false;
        }
        studentToUpdate.setIsActive(false);
        studentToUpdate.setUpdatedDate(new Date());
        studentRepository.save(studentToUpdate);
        return true;
    }










}

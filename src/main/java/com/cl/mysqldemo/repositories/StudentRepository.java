package com.cl.mysqldemo.repositories;

import com.cl.mysqldemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    // To get all active students.
    @Query("SELECT s FROM Student s WHERE s.isActive=true")
    List<Student> getAllStudent();


    // To get active student by ID.
    @Query("SELECT s FROM Student s WHERE s.isActive=true AND s.id=:id")
    Student getById(@Param("id") Long id);


}
package com.cl.mysqldemo.repositories;

import com.cl.mysqldemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository  // connect Student with data base by using JPA.
public interface StudentRepository extends JpaRepository<Student, Long> {
}

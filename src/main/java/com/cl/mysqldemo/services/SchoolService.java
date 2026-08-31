package com.cl.mysqldemo.services;


import com.cl.mysqldemo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;
}

package com.cl.mysqldemo.controllers;


import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("School")

public class SchoolController {


    SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }



    @PostMapping("add")
    public Long addSchool(@RequestParam String schoolName, @RequestParam String location) {
        return schoolService.createSchool(schoolName, location);
    }

    @GetMapping("getAll")
    public List<School> getAllSchool() {
        return schoolService.getAllSchools();
    }

    @GetMapping("getById")
    public School gerById(@RequestParam Long id) {
        return schoolService.getById(id);
    }

    @GetMapping("update")
    public School updateSchool(@RequestParam Long id,
                               @RequestParam String name,
                               @RequestParam String location) {
       return schoolService.updateSchool(id, name, location);
    }



}
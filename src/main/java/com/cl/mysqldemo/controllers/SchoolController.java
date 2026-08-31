package com.cl.mysqldemo.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("School")

public class SchoolController {

    @PostMapping("add")
    public Long addSchool(@RequestParam String schoolName, @RequestParam String location) {
    }
}
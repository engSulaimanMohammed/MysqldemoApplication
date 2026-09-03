package com.cl.mysqldemo.controllers;


import com.cl.mysqldemo.dto.SchoolDTO;
import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.services.SchoolService;
import jakarta.validation.Valid;
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
    public Long addSchool(@Valid  @RequestBody SchoolDTO dto) {
        return schoolService.createSchool(dto.getSchoolName(), dto.getSchoolLocation());
    }

    @GetMapping("getAll")
    public List<SchoolDTO> getAllSchools() {
        List<SchoolDTO> schools = SchoolDTO.convertToDTO(schoolService.getAllSchools());
        return schools;
    }

    @GetMapping("getById")
    public SchoolDTO gerById(@RequestParam Long id) {
        return SchoolDTO.convertToDTO(schoolService.getById(id));
    }

    @PutMapping("update")
    public SchoolDTO updateSchool(@RequestBody Long id) {
       return SchoolDTO.convertToDTO(schoolService.updateSchool(, name, location));
    }


    @DeleteMapping("Delete")
    public Boolean deleteSchool(@RequestParam Long id) {
        return schoolService.deleteById(id);
    }
}

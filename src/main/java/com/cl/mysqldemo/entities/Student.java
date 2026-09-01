package com.cl.mysqldemo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;




@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String major;
    private String gender;
    private String phoneNumber;
    private String parentName;

   /* @ManyToOne // relationship between student and school.
    private School school; // // relationship between student and school.*/

    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

}

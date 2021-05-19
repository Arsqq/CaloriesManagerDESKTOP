package com.kursach.OOPProject.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
@Data
public class UsersIndInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private double bodyMassIndex;
    private double dailyCaloriesIntake;
    private double weight;
    private double height;


}

package com.Model;

import javax.persistence.*;

@Entity
@Table(name = "norma")
public class Norma extends Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String age;
    private String sex;
    private double erythrocytes;
    private int platelets;
    private double leukocytes;
    private int hemoglobin;
}

package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "normals")
public class Norma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonProperty("Age")
    @Enumerated(EnumType.STRING)
    private Age age;
    @JsonProperty("Sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @JsonProperty("Erythrocytes")
    private double erythrocytes;
    @JsonProperty("Platelets")
    private int platelets;
    @JsonProperty("Leukocytes")
    private double leukocytes;
    @JsonProperty("Hemoglobin")
    private int hemoglobin;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public double getErythrocytes() {
        return erythrocytes;
    }

    public void setErythrocytes(double erythrocytes) {
        this.erythrocytes = erythrocytes;
    }

    public int getPlatelets() {
        return platelets;
    }

    public void setPlatelets(int platelets) {
        this.platelets = platelets;
    }

    public double getLeukocytes() {
        return leukocytes;
    }

    public void setLeukocytes(double leukocytes) {
        this.leukocytes = leukocytes;
    }

    public int getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(int hemoglobin) {
        this.hemoglobin = hemoglobin;
    }
}

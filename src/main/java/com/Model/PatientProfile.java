package com.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PatientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}

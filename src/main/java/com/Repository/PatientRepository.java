package com.repository;

import com.model.Age;
import com.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByName(String name);

    Patient findByName(String kit);

    List<Patient> findAllByAge(Age age);
}

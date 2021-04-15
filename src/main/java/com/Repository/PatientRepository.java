package com.Repository;

import com.Model.Patient;
import com.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

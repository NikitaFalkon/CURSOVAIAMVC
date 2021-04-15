package com.Service;

import com.Model.Patient;
import com.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl {
    @Autowired
    PatientRepository patientRepository;
    public List<Patient> readAll() {
        return patientRepository.findAll();
    }
    public void Create(Patient patient)
    {
        patientRepository.save(patient);
    }
    public Optional<Patient> FindById(Long id) {
        return patientRepository.findById(id);
    }
    public boolean redactPatient(String name, String surname,
                                 double erythrocytes,
                                 int platelets,
                                 double leukocytes,
                                 int hemoglobin, long id)
    {
        Patient patient = patientRepository.findById(id).orElseThrow();
        if (patient!=null)
        {
            patient.setName(name);
            patient.setSurname(surname);
            patient.setErythrocytes(erythrocytes);
            patient.setHemoglobin(hemoglobin);
            patient.setLeukocytes(leukocytes);
            patient.setPlatelets(platelets);
            patientRepository.save(patient);
            return true;
        }
        return false;
    }
    public void delete(Long id)
    {
        Patient patient =patientRepository.findById(id).orElseThrow();
        patientRepository.delete(patient);
    }
    public Patient show(long id)
    {
        return patientRepository.findById(id).orElseThrow();
    }
}

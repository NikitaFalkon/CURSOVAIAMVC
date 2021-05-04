package com.service;

import com.model.Patient;
import com.repository.PatientRepository;
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
    public boolean Create(Patient patient)
    {
        patientRepository.save(patient);
        return true;
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
        System.out.println(name);
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
    public void deleteAll()
    {
        patientRepository.deleteAll();
    }
    public Patient show(long id)
    {
        return patientRepository.findById(id).orElseThrow();
    }

    public List<Patient> findByFirstName(String name) {
        return patientRepository.findAllByName(name);
    }

    public boolean FindPatient(Patient patient) {
        Patient patient1 = patientRepository.findByName(patient.getName());
        if(patient1!=null)
        {
            return true;
        }
        return false;
    }

    public boolean redactPatient(long id, String notname) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        if (patient!=null)
        {
            patient.setName(notname);
            patientRepository.save(patient);
            return true;
        }
        return false;
    }
}

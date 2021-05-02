package com.service;

import com.model.Norma;
import com.model.Patient;
import com.repository.NormaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NormaService {
    @Autowired
    NormaRepository normaRepository;
    public Norma Find(String age, String sex)
    {
       List<Norma> normals = normaRepository.findAllByAge(age);
        System.out.println(normals);
        List<Norma> normals1 = normaRepository.findAll();
        System.out.println(normals1);
        for (Norma norma: normals) {
            System.out.println(sex + norma.getSex());
            if (norma.getSex().equals(sex))
            {
                Norma norma1 = norma;
                System.out.println(norma1);
                return norma;
            }
        }
        return null;
    }
    public List<Norma> allNormals()
    {
        return normaRepository.findAll();
    }

    public void Create(Norma norma)
    {
        normaRepository.save(norma);
    }

/*    public void Delete(Long id) {
        Norma norma = normaRepository.findById(id).orElseThrow();
        normaRepository.delete(norma);
    }*/

    public void DeleteAll() {
        normaRepository.deleteAll();
    }

    public boolean isnotEmpty() {
        List<Norma> normas = normaRepository.findAll();
        if(normas.isEmpty())
        {
            return false;
        }
        return true;
    }

    public Optional<Norma> FindById(Long id) {
        return normaRepository.findById(id);
    }

    public boolean redactNorma(double erythrocytes,
                                 int platelets,
                                 double leukocytes,
                                 int hemoglobin,
                                 long id) {
        Norma norma = normaRepository.findById(id).orElseThrow();
        if (norma!=null)
        {
            norma.setErythrocytes(erythrocytes);
            norma.setHemoglobin(hemoglobin);
            norma.setLeukocytes(leukocytes);
            norma.setPlatelets(platelets);
            normaRepository.save(norma);
            return true;
        }
        return false;
    }
}

package com.Service;

import com.Model.Norma;
import com.Model.User;
import com.Repository.NormaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Norma> findByName(String name) {
        return normaRepository.findAllByName(name);
    }
}

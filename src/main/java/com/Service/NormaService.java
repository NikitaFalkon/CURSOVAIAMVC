package com.Service;

import com.Model.Norma;
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
        for (Norma norma: normals) {
            if (norma.getSex().equals(sex))
            {
                return norma;
            }
        }
        return null;
    }
}

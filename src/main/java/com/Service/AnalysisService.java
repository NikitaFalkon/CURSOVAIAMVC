package com.service;

import com.model.Age;
import com.model.Analys;
import com.model.Norma;
import com.model.Patient;
import com.repository.AnalysisRepository;
import com.repository.NormaRepository;
import com.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalysisService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    NormaRepository normaRepository;
    @Autowired
    AnalysisRepository analysisRepository;
    @Autowired
    Analysis analysing;
    public void Create()
    {
        List<Analys> analysisList = new ArrayList<>();
        analysisRepository.deleteAll();
        for (Age age : Age.values())
        {
            Analys analysis = new Analys();
            analysis.setName(age);
            List<Patient> patientList = patientRepository.findAllByAge(age);
            List<Norma> normals = normaRepository.findAllByAge(age);
            for (Norma norma : normals)
            {
                for (Patient patient : patientList)
                {
                    if(norma.getSex().equals(patient.getSex()))
                    {
                        Solving(patient.getPlatelets(), norma.getPlatelets(), analysis);
                        Solving(patient.getHemoglobin(), norma.getHemoglobin(), analysis);
                        Solving(patient.getErythrocytes(), norma.getErythrocytes(), analysis);
                        Solving(patient.getPlatelets(), norma.getPlatelets(), analysis);
                        Health(patient, analysis);
                    }
                }
            }
            analysisList.add(analysis);
            analysisRepository.save(analysis);
        }
    }
    public void Health(Patient patient, Analys analys)
    {
        if(analysing.Сomparison(patient).equals("You are normal"))
        {
            analys.Healthy();
        }
        analys.Sick();
    }
    private void Solving(int i, int i1, Analys analysis){
        if(0.85*i>i1){
            analysis.More();
        }
        else if(i<0.85*i1){
            analysis.Less();
        }
        analysis.Normal();
    }
    private void Solving(double i, double i1, Analys analysis){
        if(0.85*i>i1){
            analysis.More();
        }
        else if(i<0.85*i1){
            analysis.Less();
        }
        analysis.Normal();
    }
}

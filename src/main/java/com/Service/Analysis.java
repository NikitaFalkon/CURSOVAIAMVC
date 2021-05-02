package com.service;

import com.model.Norma;
import com.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Analysis {
    @Autowired
    PatientServiceImpl patientService;
    @Autowired
    NormaService normaService;
    public String Сomparison(Patient patient)
    {
        Norma norma = normaService.Find(patient.getAge(), patient.getSex());
        return Analysing(patient, norma);
    }
    private String Analysing(Patient patient, Norma norma){
        String result="";
        result=result+Solving(patient.getErythrocytes(),norma.getErythrocytes(), "erythrocytes")
                +Solving(patient.getHemoglobin(),norma.getHemoglobin(),"hemoglobin")
                +Solving(patient.getLeukocytes(),norma.getLeukocytes(),"leukocytes")
                +Solving(patient.getPlatelets(),norma.getPlatelets(), "platelets");
        if(result.equals("")){
            result="You are normal";
        }
        return result;
    }
    private String Solving(int i, int i1, String st){
        if(0.85*i>i1){
            return "You have too much "+st+".\n";
        }
        else if(i<0.85*i1){
            return "You dont have enough "+st+".\n";
        }
        return "";
    }
    private String Solving(double i, double i1, String st){
        if(0.85*i>i1){
            return "You have too much "+st+".\n";
        }
        else if(i<0.85*i1){
            return "You dont have enough "+st+".\n";
        }
        return "";
    }
}

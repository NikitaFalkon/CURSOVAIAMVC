package com.service;

import com.model.Norma;
import com.model.Patient;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Analysis {
    @Autowired
    PatientServiceImpl patientService;
    @Autowired
    NormaService normaService;
    public static double roundAvoid(double value) {
        double result = DoubleRounder.round(value, 2);
        System.out.println(result);
        return  result;
    }
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
            double q = 100 - roundAvoid((100*i1)/i);
            return "You have too much "+st+"("+q+"%)\n";
        }
        else if(i<0.85*i1){
            double q = 100 - roundAvoid((100*i)/i1);
            return "You dont have enough "+st+"("+q+"%)\n";
        }
        return "";
    }
    private String Solving(double i, double i1, String st){
        if(0.85*i>i1){
            double q = 100 - roundAvoid((100*i1)/i);
            return "You have too much "+st+"("+q+"%)\n";
        }
        else if(i<0.85*i1){
            double q = 100 - roundAvoid((100*i)/i1);
            return "You dont have enough "+st+"("+q+"%)\n";
        }
        return "";
    }
}

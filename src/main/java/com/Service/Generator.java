package com.service;

import com.model.Patient;
import com.model.Age;
import com.model.Sex;
import org.decimal4j.util.DoubleRounder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    public static double roundAvoid(double value) {
       /* MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(value, context);*/
        double result = DoubleRounder.round(value, 2);
        System.out.println(result);
        return  result;
    }
    public List<Patient> generatePatient()
    {
        String[] names = {"Tom", "Martin", "Kim", "Sasha",
                "Jack", "Toni", "Green", "Sophia", "Pavel"};
        List<String> freeNames = null;
        freeNames = new ArrayList<>(Arrays.asList(names));
        String[] surnames = {"Kit", "Nekit", "Cat", "Po",
                "Dog", "Fish", "Bird", "Mouse", "Red"}; //Да я решил дать своим пациентам фамилии животных
        List<String> freeSurnames = null;
        freeSurnames = new ArrayList<>(Arrays.asList(surnames));
        Sex[] sex = {Sex.Man, Sex.Woman};
        Age[] age = {Age.Adult, Age.Child, Age.Teenager};

        List<Patient> patients = new ArrayList<>();
        for (int i=0; i<7; i++)
        {
            Patient patient = new Patient();
            Random rnd = new Random();
            patient.setName(freeNames.remove(rnd.nextInt(freeNames.size())));
            patient.setSurname(freeSurnames.remove(rnd.nextInt(freeSurnames.size())));
            patient.setSex(sex[(int)(0+Math.random()*2)]);
            patient.setAge(age[(int)(0+Math.random()*3)]);
            patient.setErythrocytes(roundAvoid(3.2+Math.random()*2.0));
            patient.setHemoglobin((int)(110+Math.random()*51));
            patient.setLeukocytes(roundAvoid(5.6+Math.random()*3.0));
            patient.setPlatelets((int)(220+Math.random()*90));
            patients.add(patient);
        }
        return patients;
    }

}

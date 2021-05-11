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
    public static List<String> generateRandomWords(int numberOfWords)
    {
        List<String> randomStrings = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings.add(new String(word));
        }
        return randomStrings;
    }
    public List<Patient> generatePatient()
    {
        /*String[] names = {"Tom", "Martin", "Kim", "Sasha",
                "Jack", "Toni", "Green", "Sophia", "Pavel",
                "Q", "E", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V",
                "QQ", "EQ", "DQ", "FQ", "GQ", "HQ", "JQ", "KQ", "LQ", "ZQ", "XQ", "CQ", "VQ",
                "QQ", "EQ", "DQ", "FQ", "GQ", "HQ", "JQ", "KQ", "LQ", "ZQ", "XQ", "CQ", "VQ",
                "R", "T", "Y", "U", "I", "O", "P", "A", "S", "B", "N", "M", "Z",
                "Dog", "Fish", "Bird", "Mouse", "Red"};*/
        List<String> freeNames = null;
       // freeNames = new ArrayList<>(Arrays.asList(names));
        freeNames = generateRandomWords(25);
       /* String[] surnames = {"Kit", "Nekit", "Cat", "Po",
                "Dog", "Fish", "Bird", "Mouse", "Red", "W",
                "R", "T", "Y", "U", "I", "O", "P", "A", "S", "B", "N", "M", "Z",
                "Q", "E", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V",
                "QQ", "EQ", "DQ", "FQ", "GQ", "HQ", "JQ", "KQ", "LQ", "ZQ", "XQ", "CQ", "VQ",
                "QQ", "EQ", "DQ", "FQ", "GQ", "HQ", "JQ", "KQ", "LQ", "ZQ", "XQ", "CQ", "VQ",
                "Jack", "Toni", "Green", "Sophia", "Pavel",};*/ //Да я решил дать своим пациентам фамилии животных
        //List<String> freeSurnames = null;
        //freeSurnames = new ArrayList<>(Arrays.asList(surnames));
        List<String> freeSurnames = generateRandomWords(25);
        Sex[] sex = {Sex.Man, Sex.Woman};
        Age[] age = {Age.Adult, Age.Child, Age.Teenager};

        List<Patient> patients = new ArrayList<>();
        for (int i=0; i<23; i++)
        {
            Patient patient = new Patient();
            Random rnd = new Random();
            patient.setName(freeNames.remove(rnd.nextInt(freeNames.size())));
            patient.setSurname(freeSurnames.remove(rnd.nextInt(freeSurnames.size())));
            patient.setSex(sex[(int)(0+Math.random()*2)]);
            patient.setAge(age[(int)(0+Math.random()*3)]);
            patient.setErythrocytes(roundAvoid(3.2+Math.random()*2.2));
            patient.setHemoglobin((int)(94+Math.random()*55));
            patient.setLeukocytes(roundAvoid(5.4+Math.random()*3.0));
            patient.setPlatelets((int)(240+Math.random()*90));
            patients.add(patient);
        }
        return patients;
    }

}

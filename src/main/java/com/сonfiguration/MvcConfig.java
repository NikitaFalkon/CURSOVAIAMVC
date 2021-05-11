package com.сonfiguration;

import com.model.Age;
import com.model.Norma;
import com.model.Patient;
import com.model.Sex;
import com.service.AnalysisService;
import com.service.Generator;
import com.service.NormaService;
import com.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    NormaService normaService;
    @Autowired
    AnalysisService analysisService;
    @Autowired
    PatientServiceImpl patientService;
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/login").setViewName("login");
    }
    @PostConstruct
    public void load() {
        /*normaService.DeleteAll();
        Norma norma = new Norma();
        norma.setSex(Sex.Man);
        norma.setAge(Age.Child);
        norma.setErythrocytes(4.00);
        norma.setHemoglobin(130);
        norma.setLeukocytes(7.50);
        norma.setPlatelets(270);
        Norma norma1 = new Norma();
        norma1.setSex(Sex.Man);
        norma1.setAge(Age.Adult);
        norma1.setErythrocytes(4.50);
        norma1.setHemoglobin(145);
        norma1.setLeukocytes(6.50);
        norma1.setPlatelets(250);
        Norma norma2 = new Norma();
        norma2.setSex(Sex.Man);
        norma2.setAge(Age.Teenager);
        norma2.setErythrocytes(4.20);
        norma2.setHemoglobin(130);
        norma2.setLeukocytes(6.70);
        norma2.setPlatelets(260);
        Norma norma3 = new Norma();
        norma3.setSex(Sex.Woman);
        norma3.setAge(Age.Child);
        norma3.setErythrocytes(4.50);
        norma3.setHemoglobin(145);
        norma3.setLeukocytes(6.50);
        norma3.setPlatelets(250);
        Norma norma4 = new Norma();
        norma4.setSex(Sex.Woman);
        norma4.setAge(Age.Adult);
        norma4.setErythrocytes(4.20);
        norma4.setHemoglobin(130);
        norma4.setLeukocytes(6.50);
        norma4.setPlatelets(240);
        Norma norma5 = new Norma();
        norma5.setSex(Sex.Woman);
        norma5.setAge(Age.Teenager);
        norma5.setErythrocytes(4.20);
        norma5.setHemoglobin(130);
        norma5.setLeukocytes(6.70);
        norma5.setPlatelets(260);*/
        /*normaService.Create(norma);
        normaService.Create(norma1);
        normaService.Create(norma2);
        normaService.Create(norma3);
        normaService.Create(norma4);
        normaService.Create(norma5);*/
        analysisService.Create();
        patientService.deleteAll();
        Generator generator = new Generator();
        List<Patient> userList = generator.generatePatient();
        System.out.println(userList);
        userList.forEach(patient -> {patientService.Create(patient);});
        analysisService.Create();
    }
}
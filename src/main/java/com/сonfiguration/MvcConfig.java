package com.сonfiguration;

import com.model.Norma;
import com.service.NormaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    NormaService normaService;
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/login").setViewName("login");
    }
    @PostConstruct
    public void load() {
        normaService.DeleteAll();
        Norma norma = new Norma();
        norma.setSex("Man");
        norma.setAge("Child");
        norma.setErythrocytes(1);
        norma.setHemoglobin(1);
        norma.setLeukocytes(1);
        norma.setPlatelets(1);
        Norma norma1 = new Norma();
        norma1.setSex("Man");
        norma1.setAge("Adult");
        norma1.setErythrocytes(1);
        norma1.setHemoglobin(1);
        norma1.setLeukocytes(1);
        norma1.setPlatelets(1);
        Norma norma2 = new Norma();
        norma2.setSex("Man");
        norma2.setAge("Teenager");
        norma2.setErythrocytes(1);
        norma2.setHemoglobin(1);
        norma2.setLeukocytes(1);
        norma2.setPlatelets(1);
        Norma norma3 = new Norma();
        norma3.setSex("Woman");
        norma3.setAge("Child");
        norma3.setErythrocytes(1);
        norma3.setHemoglobin(1);
        norma3.setLeukocytes(1);
        norma3.setPlatelets(1);
        Norma norma4 = new Norma();
        norma4.setSex("Woman");
        norma4.setAge("Adult");
        norma4.setErythrocytes(1);
        norma4.setHemoglobin(1);
        norma4.setLeukocytes(1);
        norma4.setPlatelets(1);
        Norma norma5 = new Norma();
        norma5.setSex("Woman");
        norma5.setAge("Teenager");
        norma5.setErythrocytes(1);
        norma5.setHemoglobin(1);
        norma5.setLeukocytes(1);
        norma5.setPlatelets(1);
        normaService.Create(norma);
        normaService.Create(norma1);
        normaService.Create(norma2);
        normaService.Create(norma3);
        normaService.Create(norma4);
        normaService.Create(norma5);
    }
}
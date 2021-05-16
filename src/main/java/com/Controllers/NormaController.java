package com.controllers;

import com.model.Norma;
import com.service.NormaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class NormaController {
    @Autowired
    NormaService normaService;

    @GetMapping("/normals/{id}/edit")
    public String EditPatient(Model model, @PathVariable Long id) {
        Optional<Norma> patient = normaService.FindById(id);
        ArrayList<Norma> normals = new ArrayList<>();
        patient.ifPresent(normals::add);
        model.addAttribute("normals", normals);
        return "redactnorma";
    }

    @PostMapping("/normals/{id}/edit")
    public String Redacting(@PathVariable(name = "id") long id,
                            @RequestParam(name = "erythrocytes") double erythrocytes,
                            @RequestParam(name = "platelets") int platelets,
                            @RequestParam(name = "leukocytes") double leukocytes,
                            @RequestParam(name = "hemoglobin") int hemoglobin,
                            Model model) {

        if (!normaService.redactNorma(erythrocytes, platelets, leukocytes, hemoglobin, id)) {
            model.addAttribute("usernameError", "There is no such a norma");
            return "redirect:/{id}/edit";
        }
        return "redirect:/normals";
    }
}

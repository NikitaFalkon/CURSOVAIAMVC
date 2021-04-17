package com.Controllers;

import com.Model.Patient;
import com.Service.Analysis;
import com.Service.NormaService;
import com.Service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    PatientServiceImpl patientService;
    @Autowired
    Analysis analysis;
    @Autowired
    NormaService normaService;
    @GetMapping("/patients")
    public String Patients(Model model)
    {
        model.addAttribute("patients", patientService.readAll());
        return "Patients";
    }
    @GetMapping("/normals")
    public String Normals(Model model)
    {
        model.addAttribute("normals", normaService.allNormals());
        return "Normals";
    }
    @GetMapping("/patientsall")
    public String PatientsFind(Model model, @RequestParam(name = "firstname", required = false) String name)
    {
        model.addAttribute("patients", patientService.findByFirstName(name));
        return "Patients";
    }
    @GetMapping("/new")
    public String NewPatient(Model model)
    {
        model.addAttribute("patient", new Patient());
        return "NewPatient";
    }
    @PostMapping("/new")
    public String Creating(@ModelAttribute("patient") @Valid Patient patient, Model model)
    {
        patientService.Create(patient);
        return "redirect:/";
    }
    @GetMapping("patient/{id}")
    public String index(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("patient", patientService.show(id));
        model.addAttribute("text", analysis.Сomparison(patientService.show(id)));
        return "Index";
    }
    @GetMapping("/patient/{id}/edit")
    public String EditPatient(Model model, @PathVariable Long id)
    {
        Optional<Patient> patient = patientService.FindById(id);
        ArrayList<Patient> patients = new ArrayList<>();
        patient.ifPresent(patients::add);
        model.addAttribute("patients", patients);
        return "Edit";
    }
    @PostMapping("/patient/{id}/edit")
    public String Redacting(@PathVariable(name = "id") long id,
                            @RequestParam(name = "name", required = false) String name,
                            @RequestParam(name = "surname", required = false) String surname,
                            @RequestParam(name = "erythrocytes") double erythrocytes,
                            @RequestParam(name = "platelets") int platelets,
                            @RequestParam(name = "leukocytes") double leukocytes,
                            @RequestParam(name = "hemoglobin") int hemoglobin,
                            Model model)
    {
        ;
        if (!patientService.redactPatient(name,surname, erythrocytes, platelets, leukocytes, hemoglobin, id)){
            model.addAttribute("usernameError", "There is no such a user");
            return "redirect:/{id}/edit";
        }
        return "redirect:/";
    }
    @GetMapping("/patient/{id}/delete")
    public String DeletePatient(Model model, @PathVariable Long id)
    {
        patientService.delete(id);
        return "redirect:/";
    }

}

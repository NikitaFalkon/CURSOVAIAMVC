package com.controllers;

import com.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RepoController {
    @Autowired
    AnalysisService analysisService;
    @GetMapping("/report")
    public RedirectView Table()
    {
        analysisService.Create();
        return new RedirectView("http://localhost:9090/report?format=table");
    }
    /*@GetMapping("/report/diagram")
    public RedirectView Diagram()
    {
        return new RedirectView("http://localhost:9090/report?format=diagram");
    }*/
}

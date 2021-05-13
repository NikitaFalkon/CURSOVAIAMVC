package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RepoController {
    @GetMapping("/report/table")
    public RedirectView Table()
    {
        return new RedirectView("http://localhost:9090/report?format=table");
    }
    @GetMapping("/report/diagram")
    public RedirectView Diagram()
    {
        return new RedirectView("http://localhost:9090/report?format=diagram");
    }
}

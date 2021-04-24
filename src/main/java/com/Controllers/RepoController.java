package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RepoController {
    @GetMapping("/report")
    public RedirectView Redirect ()
    {
        return new RedirectView("http://localhost:9090/report/pdf");
    }
}

package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RepoController {
    @GetMapping("/report")
    public RedirectView Redirecting (@RequestParam(name = "sex", required = false) String sex,
                                     @RequestParam(name = "age", required = false) String age)
    {
        return new RedirectView("http://localhost:9090/report?sex="+sex+"&age="+age);
    }
    @GetMapping("/reporting")
    public String Redirect ()
    {
        return "report";
    }
}

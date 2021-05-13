package com.controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller

public class MenuController {
    @GetMapping("/")
    public String Login()
    {
        return "menulogin";
    }

    @GetMapping("/menu")
    public String MenuUser() {
        return "menu";
    }
/*    @GetMapping("/menuadmin")
    public String MenuAdmin() {return "MenuAdmin";}*/
    @GetMapping("/ex")
    public String Ex() {return "patients";}
    @ExceptionHandler(AccessDeniedException.class)
    public void handleError(HttpServletResponse response) throws IOException {
        response.sendRedirect("/menu");
    }
}

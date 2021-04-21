package com.Controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
        return "MenuLogin";
    }

    @GetMapping("/menu")
    public String MenuUser() {
        return "Menu";
    }
/*    @GetMapping("/menuadmin")
    public String MenuAdmin() {return "MenuAdmin";}*/
    @GetMapping("/ex")
    public String Ex() {return "Ex";}
    @ExceptionHandler(AccessDeniedException.class)
    public void handleError(HttpServletResponse response) throws IOException {
        response.sendRedirect("/menu");
    }
}

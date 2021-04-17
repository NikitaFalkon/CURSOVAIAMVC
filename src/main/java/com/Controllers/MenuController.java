package com.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/")
    public String Login()
    {
        return "MenuLogin";
    }
    @GetMapping("/menu")
    public String Menu() {return "Menu";}
}

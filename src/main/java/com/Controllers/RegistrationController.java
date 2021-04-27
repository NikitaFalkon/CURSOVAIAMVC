package com.controllers;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("userForm", new User());
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm,
                          @RequestParam(name = "checkbox", required = false) boolean checkbox, Model model)
    {
        if (!userService.NewUser(userForm, checkbox)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        return "redirect:/";
    }
   /* @GetMapping("/login")
    public String Login(Model model)
    {
        model.addAttribute("user", new User());
        return "Login";
    }
    @PostMapping("/login")
    public String Loging(Model model, @RequestParam (name = "username") String username)
    {
        User user = userService.findUser(username);
        System.out.println(user.getRoles());
        if(user.getRoles().contains(Role.ADMIN))
        {
            return "MenuAdmin";
        }
        else {
            return "Menu";
        }
    }*/
}

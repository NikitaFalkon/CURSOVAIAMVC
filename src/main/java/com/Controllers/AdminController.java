package com.Controllers;

import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public String Users(Model model)
    {
        model.addAttribute("users", userService.allUsers());
        return "Users";
    }
    @GetMapping("/users/{id}")
    public String Delete(@PathVariable("id") long id, Model model)
    {
        userService.DeleteUser(id);
        return "redirect:/users";
    }

}

package com.controllers;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String Users(Model model)
    {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }
    @GetMapping("/users/{id}")
    public String Delete(@PathVariable("id") long id, Model model)
    {
        userService.DeleteUser(id);
        return "redirect:/users";
    }
    @GetMapping("/users/{id}/edit")
    public String Edit(Model model, @PathVariable Long id)
    {
        Optional<User> user = userService.FindById(id);
        ArrayList<User> users = new ArrayList<>();
        user.ifPresent(users::add);
        model.addAttribute("users", users);
        return "edituser";
    }
    @PostMapping("/users/{id}/edit")
    public String Redacting(@PathVariable(name = "id") long id,
                            @RequestParam(name = "username", required = false) String name,
                            @RequestParam(name = "password", required = false) String password,
                            Model model)
    {

        if (!userService.redactUser(name, id)){
            model.addAttribute("usernameError", "There is no such a user");
            return "redirect:/{id}/edit";
        }
        return "redirect:/users";
    }

}

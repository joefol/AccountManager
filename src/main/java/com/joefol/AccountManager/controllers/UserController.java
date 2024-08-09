package com.joefol.AccountManager.controllers;

import com.joefol.AccountManager.users.EmailAlreadyExistsException;
import com.joefol.AccountManager.users.UserDto;
import com.joefol.AccountManager.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("user")UserDto userDto) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user")UserDto userDto, Model model) {
        try {
            userService.save(userDto);
            model.addAttribute("message", "Registered Successfully!");
            return "register";
        } catch(EmailAlreadyExistsException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user-page")
    public String userPage() {
        return "userHome";
    }

    @GetMapping("/admin-page")
    public String adminPage() {
        return "adminHome";
    }
}

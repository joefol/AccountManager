package com.joefol.MyAccounts.controllers;

import com.joefol.MyAccounts.users.UserDto;
import com.joefol.MyAccounts.users.UserService;
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

    @PostMapping("registration")
    public String saveUser(@ModelAttribute("user")UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfully!");
        return "register";
    }
}

package com.tanya.militarybase.controllers;

import com.tanya.militarybase.model.User;
import com.tanya.militarybase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }

    @PostMapping("/registration")
    public String addUser(
            User user,
            Map<String, Object> model
    ) {

        if (!userService.addUser(user)) {
            model.put("message", "User exists");
            return "registration";
        }

        return "redirect:/login";
    }
}

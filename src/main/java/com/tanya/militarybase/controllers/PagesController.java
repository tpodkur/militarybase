package com.tanya.militarybase.controllers;

import com.tanya.militarybase.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PagesController {
    @GetMapping("/")
    public String greetingPage(
            @AuthenticationPrincipal User user,
            Map<String, Object> model
    ) {
        return null != user ? "redirect:" + user.getRole().getPosition() : "/";
    }
}

package com.tanya.militarybase.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransportController {

    @GetMapping("/transport")
    public String getTransport(Map<String, Object> model) {
        return "transport";
    }

    @GetMapping("/vooruzhenie")
    public String getVooruzhenie(Map<String, Object> model) {
        return "vooruzhenie";
    }
}

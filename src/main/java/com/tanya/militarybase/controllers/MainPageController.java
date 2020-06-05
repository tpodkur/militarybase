package com.tanya.militarybase.controllers;

import com.tanya.militarybase.dao.persons.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainPageController {

    @GetMapping("/main")
    public String main(Map<String, Object> model) { return "main"; }

    @GetMapping("/forms")
    public String getForms(Map<String, Object> model) { return "forms"; }

    @GetMapping("/requests")
    public String getRequests(Map<String, Object> model) { return "requests"; }

}

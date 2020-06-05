package com.tanya.militarybase.controllers;

import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.service.FormsService;
import com.tanya.militarybase.service.PodrazdeleniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tanya.militarybase.model.podrazdelenia.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PodrazdeleniaController {

    private final PodrazdeleniaService podrazdeleniaService;
    private final FormsService formsService;

    @GetMapping("/podrazdelenia")
    public String getVoennosluzhashie(Map<String, Object> model) {
        model.put("oficerPersons", podrazdeleniaService.getAllOficerSostav());
        return "podrazdelenia";
    }

//    @GetMapping("/oficeri")
//    public String getOficerPersons(Map<String, Object> model) {
//        model.put("oficerPersons", podrazdeleniaService.getAllOficerSostav());
//        return "podrazdelenia";
//    }

    @PostMapping("/new-armia")
    public String postPerson(@RequestParam(name="id_komandir") String idKomandir) {
        Integer id = Integer.parseInt(idKomandir);
        OficerSostav oficerSostav = formsService.getOficerSostav(id);
        podrazdeleniaService.postArmia(oficerSostav);
        return "redirect:/podrazdelenia";
    }
}

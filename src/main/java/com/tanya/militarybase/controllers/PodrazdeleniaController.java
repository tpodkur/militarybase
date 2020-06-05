package com.tanya.militarybase.controllers;

import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.model.persons.Person;
import com.tanya.militarybase.service.FormsService;
import com.tanya.militarybase.service.PodrazdeleniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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
    public String postArmia(@RequestParam(name="id_komandir") String idKomandir) {
        Integer id = Integer.parseInt(idKomandir);
        OficerSostav oficerSostav = formsService.getOficerSostav(id);
        podrazdeleniaService.postArmia(oficerSostav);
        return "redirect:/podrazdelenia";
    }

    @PostMapping("/new-brigada")
    public String postBrigada(@RequestParam(name="id_komandir") String idKomandir, @RequestParam(name="id_armia") String idArmia) {
        Integer idK = Integer.parseInt(idKomandir);
        Integer idA = Integer.parseInt(idArmia);
        OficerSostav oficerSostav = formsService.getOficerSostav(idK);
        Armia armia = podrazdeleniaService.getArmia(idA);
        podrazdeleniaService.postBrigada(oficerSostav, armia);
        return "redirect:/podrazdelenia";
    }

    @PostMapping("/new-korpus")
    public String postKorpus(@RequestParam(name="id_komandir") String idKomandir, @RequestParam(name="id_brigada") String idBrigada) {
        Integer idK = Integer.parseInt(idKomandir);
        Integer idB = Integer.parseInt(idBrigada);
        OficerSostav oficerSostav = formsService.getOficerSostav(idK);
        Brigada brigada = podrazdeleniaService.getBrigada(idB);
        podrazdeleniaService.postKorpus(oficerSostav, brigada);
        return "redirect:/podrazdelenia";
    }

    @PostMapping("/new-divizia")
    public String postDivizia(@RequestParam(name="id_komandir") String idKomandir, @RequestParam(name="id_korpus") String idKorpus) {
        Integer idK = Integer.parseInt(idKomandir);
        Integer idBKorp = Integer.parseInt(idKorpus);
        OficerSostav oficerSostav = formsService.getOficerSostav(idK);
        Korpus korpus = podrazdeleniaService.getKorpus(idBKorp);
        podrazdeleniaService.postDivizia(oficerSostav, korpus);
        return "redirect:/podrazdelenia";
    }

    @PostMapping("/new-vchast")
    public String postVoinskayaChast(@RequestParam(name="id_komandir") String idKomandir, @RequestParam(name="id_divizia") String idDivizia) {
        Integer idK = Integer.parseInt(idKomandir);
        Integer idD = Integer.parseInt(idDivizia);
        OficerSostav oficerSostav = formsService.getOficerSostav(idK);
        Divizia divizia = podrazdeleniaService.getDivizia(idD);
        podrazdeleniaService.postVoinskayaChast(oficerSostav, divizia);
        return "redirect:/podrazdelenia";
    }

    @PostMapping("/new-rota")
    public String postRota(@RequestParam(name="id_komandir") String idKomandir, @RequestParam(name="id_vchast") String idVchast) {
        Integer idK = Integer.parseInt(idKomandir);
        Integer idV = Integer.parseInt(idVchast);
        OficerSostav oficerSostav = formsService.getOficerSostav(idK);
        VoinskayaChast voinskayaChast = podrazdeleniaService.getVoinskayaChast(idV);
        podrazdeleniaService.postRota(oficerSostav, voinskayaChast);
        return "redirect:/podrazdelenia";
    }

    @PostMapping("/new-vzvod")
    public String postVzvod(@RequestParam(name="id_komandir") String idKomandir, @RequestParam(name="id_rota") String idRota) {
        Integer idK = Integer.parseInt(idKomandir);
        Integer idR = Integer.parseInt(idRota);
        Person person = formsService.getPerson(idK);
        Rota rota = podrazdeleniaService.getRota(idR);
        podrazdeleniaService.postVzvod(person, rota);
        return "redirect:/podrazdelenia";
    }

    @PostMapping("/otdelenie")
    public String postOtdelenie(@RequestParam(name="id_komandir") String idKomandir, @RequestParam(name="id_vzvod") String idVzvod) {
        Integer idK = Integer.parseInt(idKomandir);
        Integer idV = Integer.parseInt(idVzvod);
        Person person = formsService.getPerson(idK);
        Vzvod vzvod = podrazdeleniaService.getVzvod(idV);
        podrazdeleniaService.postOtdelenie(person, vzvod);
        return "redirect:/podrazdelenia";
    }
}

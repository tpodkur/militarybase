package com.tanya.militarybase.controllers;

import com.tanya.militarybase.dao.OficerSostavRepository;
import com.tanya.militarybase.dao.RyadovoySostavRepository;
import com.tanya.militarybase.dao.oficer_persons_repo.*;
import com.tanya.militarybase.dao.podrazdelenia_repo.ArmiaRepository;
import com.tanya.militarybase.dao.podrazdelenia_repo.DiviziaRepository;
import com.tanya.militarybase.dao.podrazdelenia_repo.KorpusRepository;
import com.tanya.militarybase.dao.podrazdelenia_repo.VoinskayaChastRepository;
import com.tanya.militarybase.dao.ryadovoy_persons_repo.*;
import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.model.RyadovoySostav;
import com.tanya.militarybase.model.oficer_persons.*;
import com.tanya.militarybase.model.podrazdelenia.Armia;
import com.tanya.militarybase.model.podrazdelenia.Divizia;
import com.tanya.militarybase.model.podrazdelenia.Korpus;
import com.tanya.militarybase.model.ryadovoy_persons.*;
import com.tanya.militarybase.service.RequestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RequestsController {

    private final RequestsService requestsService;

    private final ArmiaRepository armiaRepository;
    private final DiviziaRepository diviziaRepository;
    private final KorpusRepository korpusRepository;
    private final VoinskayaChastRepository voinskayaChastRepository;
    private final OficerSostavRepository oficerSostavRepository;
    private final RyadovoySostavRepository ryadovoySostavRepository;

    private final GeneralRepository generalRepository;
    private final KapitanRepository kapitanRepository;
    private final LeytenantRepository leytenantRepository;
    private final MaiorRepository maiorRepository;
    private final PodpolkovnikRepository podpolkovnikRepository;
    private final PolkovnikRepository polkovnikRepository;
    private final EfreytorRepository efreytorRepository;
    private final PraporshikRepository praporshikRepository;
    private final RyadovoyModelRepository ryadovoyModelRepository;
    private final SerzhantRepository serzhantRepository;
    private final StarshinaRepository starshinaRepository;


    @GetMapping("/requests")
    public String getRequests(Map<String, Object> model) {
        model.put("armii", armiaRepository.findAll());
        model.put("divizii", diviziaRepository.findAll());
        model.put("korpusi", korpusRepository.findAll());
        return "requests";
    }

    @GetMapping("/vchasty-by-armia")
    public String infoVchastyByArmia(@RequestParam(name="armia") Armia armia, Map<String, Object> model) {
        model.put("vchasti", requestsService.findChastByArmia(armia));
        return "requests";
    }

    @GetMapping("/vchasty-by-divizia")
    public String infoVchastyByDivizia(@RequestParam(name="divizia") Divizia divizia, Map<String, Object> model) {
        model.put("vchasti", requestsService.findChastByDivizia(divizia));
        return "requests";
    }

    @GetMapping("/vchasty-by-korpus")
    public String infoVchastyByKorpus(@RequestParam(name="korpus") Korpus korpus, Map<String, Object> model) {
        model.put("vchasti", requestsService.findChastByKorpus(korpus));
        return "requests";
    }

    @GetMapping("/vchasty-all")
    public String infoAllVchasty(Map<String, Object> model) {
        model.put("vchasti", voinskayaChastRepository.findAll());
        return "requests";
    }

    @GetMapping("/ofsostav-all")
    public String infoAllOficers(Map<String, Object> model) {
        model.put("oficers", oficerSostavRepository.findAll());
        return "requests";
    }

    @GetMapping("/ofsostav-spec")
    public String infoAllOficers(@RequestParam(name="specialnost_name") String spec, Map<String, Object> model) {
        List<OficerSostav> oficerSostavList = new ArrayList<OficerSostav>();
        switch (spec) {
            case "GENERAL":
                List<General> generals = generalRepository.findAll();
                for (General general : generals) {
                    oficerSostavList.add(general.getOficerSostav());
                }
                model.put("oficers", oficerSostavList);
                break;
            case "POLKOVNIK":
                List<Polkovnik> polkovniks = polkovnikRepository.findAll();
                for (Polkovnik polkovnik : polkovniks) {
                    oficerSostavList.add(polkovnik.getOficerSostav());
                }
                model.put("oficers", oficerSostavList);
                break;
            case "PODPOLKOVNIK":
                List<Podpolkovnik> podpolkovniks = podpolkovnikRepository.findAll();
                for (Podpolkovnik podpolkovnik : podpolkovniks) {
                    oficerSostavList.add(podpolkovnik.getOficerSostav());
                }
                model.put("oficers", oficerSostavList);
            case "MAIOR":
                List<Maior> maiors = maiorRepository.findAll();
                for (Maior maior : maiors) {
                    oficerSostavList.add(maior.getOficerSostav());
                }
                model.put("oficers", oficerSostavList);
                break;
            case "KAPITAN":
                List<Kapitan> kapitans = kapitanRepository.findAll();
                for (Kapitan kapitan : kapitans) {
                    oficerSostavList.add(kapitan.getOficerSostav());
                }
                model.put("oficers", oficerSostavList);
                break;
            case "LEYTENANT":
                List<Leytenant> leytenants = leytenantRepository.findAll();
                for (Leytenant leytenant : leytenants) {
                    oficerSostavList.add(leytenant.getOficerSostav());
                }
                model.put("oficers", oficerSostavList);
                break;
        }
        return "requests";
    }

    @GetMapping("/rsostav-all")
    public String infoAllRyadovie(Map<String, Object> model) {
        model.put("ryadovie", ryadovoySostavRepository.findAll());
        return "requests";
    }

    @GetMapping("/rsostav-spec")
    public String infoAllRyadovie(@RequestParam(name="specialnost_name") String spec, Map<String, Object> model) {
        List<RyadovoySostav> ryadovoySostavList = new ArrayList<RyadovoySostav>();
        switch (spec) {
            case "STARSHINA":
                List<Starshina> starshinas = starshinaRepository.findAll();
                for (Starshina starshina : starshinas) {
                    ryadovoySostavList.add(starshina.getRyadovoySostav());
                }
                model.put("ryadovie", ryadovoySostavList);
                break;
            case "SERZHANT":
                List<Serzhant> serzhants = serzhantRepository.findAll();
                for (Serzhant serzhant : serzhants) {
                    ryadovoySostavList.add(serzhant.getRyadovoySostav());
                }
                model.put("ryadovie", ryadovoySostavList);
                break;
            case "PRAPORSHIK":
                List<Praporshik> praporshiks = praporshikRepository.findAll();
                for (Praporshik praporshik : praporshiks) {
                    ryadovoySostavList.add(praporshik.getRyadovoySostav());
                }
                model.put("ryadovie", ryadovoySostavList);
            case "EFREYTOR":
                List<Efreytor> efreytors = efreytorRepository.findAll();
                for (Efreytor efreytor : efreytors) {
                    ryadovoySostavList.add(efreytor.getRyadovoySostav());
                }
                model.put("ryadovie", ryadovoySostavList);
                break;
            case "RYADOVOY":
                List<RyadovoyModel> ryadovoys = ryadovoyModelRepository.findAll();
                for (RyadovoyModel ryadovoy : ryadovoys) {
                    ryadovoySostavList.add(ryadovoy.getRyadovoySostav());
                }
                model.put("ryadovie", ryadovoySostavList);
                break;
        }
        return "requests";
    }
}

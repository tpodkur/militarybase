package com.tanya.militarybase.service;

import com.tanya.militarybase.dao.OficerSostavRepository;
import com.tanya.militarybase.dao.RyadovoySostavRepository;
import com.tanya.militarybase.dao.oficer_persons_repo.*;
import com.tanya.militarybase.dao.persons.PersonRepository;
import com.tanya.militarybase.dao.ryadovoy_persons_repo.*;
import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.model.RyadovoySostav;
import com.tanya.militarybase.model.join_entities.OficerSostavPerson;
import com.tanya.militarybase.model.oficer_persons.*;
import com.tanya.militarybase.model.persons.Person;
import com.tanya.militarybase.model.ryadovoy_persons.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FormsService {
    private final PersonRepository personRepository;

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

    public Person postPerson(String firstName, String lastName, String thirdName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setThirdName(thirdName);
        personRepository.save(person);
        return person;
    }

    public OficerSostav postOficerSostav(Person person) {
        OficerSostav oficerSostav = new OficerSostav();
        oficerSostav.setPerson(person);
        oficerSostavRepository.save(oficerSostav);
        return oficerSostav;
    }

    public RyadovoySostav postRyadovoySostav(Person person) {
        RyadovoySostav ryadovoySostav = new RyadovoySostav();
        ryadovoySostav.setPerson(person);
        ryadovoySostavRepository.save(ryadovoySostav);
        return ryadovoySostav;
    }

    public void postOficerSpecialnost(
            OficerSostav sostav,
            String name,
            Boolean character1,
            String character2,
            Integer character3
    ) {
        switch (name) {
            case "GENERAL":
                General general = new General();
                general.setOficerSostav(sostav);
                general.setCharacteristic1(character1);
                general.setCharacteristic2(character2);
                general.setCharacteristic3(character3);
                generalRepository.save(general);
                break;
            case "POLKOVNIK":
                Polkovnik polkovnik = new Polkovnik();
                polkovnik.setOficerSostav(sostav);
                polkovnik.setCharacteristic1(character1);
                polkovnik.setCharacteristic2(character2);
                polkovnik.setCharacteristic3(character3);
                polkovnikRepository.save(polkovnik);
                break;
            case "PODPOLKOVNIK":
                Podpolkovnik podpolkovnik = new Podpolkovnik();
                podpolkovnik.setOficerSostav(sostav);
                podpolkovnik.setCharacteristic1(character1);
                podpolkovnik.setCharacteristic2(character2);
                podpolkovnik.setCharacteristic3(character3);
                podpolkovnikRepository.save(podpolkovnik);
                break;
            case "MAIOR":
                Maior maior = new Maior();
                maior.setOficerSostav(sostav);
                maior.setCharacteristic1(character1);
                maior.setCharacteristic2(character2);
                maior.setCharacteristic3(character3);
                maiorRepository.save(maior);
                break;
            case "KAPITAN":
                Kapitan kapitan = new Kapitan();
                kapitan.setOficerSostav(sostav);
                kapitan.setCharacteristic1(character1);
                kapitan.setCharacteristic2(character2);
                kapitan.setCharacteristic3(character3);
                kapitanRepository.save(kapitan);
                break;
            case "LEYTENANT":
                Leytenant leytenant = new Leytenant();
                leytenant.setOficerSostav(sostav);
                leytenant.setCharacteristic1(character1);
                leytenant.setCharacteristic2(character2);
                leytenant.setCharacteristic3(character3);
                leytenantRepository.save(leytenant);
                break;
        }
    }

    public void postRyadovoySpecialnost(
            RyadovoySostav sostav,
            String name,
            Boolean character1,
            String character2,
            Integer character3
    ) {
        switch (name) {
            case "STARSHINA":
                Starshina starshina = new Starshina();
                starshina.setRyadovoySostav(sostav);
                starshina.setCharacteristic1(character1);
                starshina.setCharacteristic2(character2);
                starshina.setCharacteristic3(character3);
                starshinaRepository.save(starshina);
                break;
            case "SERZHANT":
                Serzhant serzhant = new Serzhant();
                serzhant.setRyadovoySostav(sostav);
                serzhant.setCharacteristic1(character1);
                serzhant.setCharacteristic2(character2);
                serzhant.setCharacteristic3(character3);
                serzhantRepository.save(serzhant);
                break;
            case "PRAPORSHIK":
                Praporshik praporshik = new Praporshik();
                praporshik.setRyadovoySostav(sostav);
                praporshik.setCharacteristic1(character1);
                praporshik.setCharacteristic2(character2);
                praporshik.setCharacteristic3(character3);
                praporshikRepository.save(praporshik);
                break;
            case "EFREYTOR":
                Efreytor efreytor = new Efreytor();
                efreytor.setRyadovoySostav(sostav);
                efreytor.setCharacteristic1(character1);
                efreytor.setCharacteristic2(character2);
                efreytor.setCharacteristic3(character3);
                efreytorRepository.save(efreytor);
                break;
            case "RYADOVOY":
                RyadovoyModel ryadovoy = new RyadovoyModel();
                ryadovoy.setRyadovoySostav(sostav);
                ryadovoy.setCharacteristic1(character1);
                ryadovoy.setCharacteristic2(character2);
                ryadovoy.setCharacteristic3(character3);
                ryadovoyModelRepository.save(ryadovoy);
                break;
        }
    }

    public OficerSostav getOficerSostav(Integer id){
        OficerSostav oficerSostav = oficerSostavRepository.findById(id).get();
        if (oficerSostav == null) {
            System.out.println("problem");
        }
        return oficerSostav;
    }
}

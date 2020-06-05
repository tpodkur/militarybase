package com.tanya.militarybase.service;

import com.tanya.militarybase.dao.OficerSostavRepository;
import com.tanya.militarybase.dao.persons.PersonRepository;
import com.tanya.militarybase.dao.podrazdelenia_repo.*;
import com.tanya.militarybase.model.OficerSostav;
import com.tanya.militarybase.model.join_entities.OficerSostavPerson;
import com.tanya.militarybase.model.persons.Oficer;
import com.tanya.militarybase.model.persons.Person;
import com.tanya.militarybase.model.podrazdelenia.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PodrazdeleniaService {

    private final PersonRepository personRepository;
    private final OficerSostavRepository oficerSostavRepository;
    private final ArmiaRepository armiaRepository;
    private final BrigadaRepository brigadaRepository;
    private final DiviziaRepository diviziaRepository;
    private final KorpusRepository korpusRepository;
    private final OtdelenieRepository otdelenieRepository;
    private final RotaRepository rotaRepository;
    private final VoinskayaChastRepository voinskayaChastRepository;
    private final VzvodRepository vzvodRepository;

    public List<OficerSostavPerson> getAllOficerSostav() {
        List<Person> allPersons = personRepository.findAll();

        List<OficerSostavPerson> oficerPersons = new ArrayList<>();

        for(int i=0; i<allPersons.size(); i++) {
            Person currentPerson = allPersons.get(i);
            OficerSostav oficer = oficerSostavRepository.findByPerson(currentPerson);
            if (null == oficer) {
                System.out.println("null");
                continue;
            }
            OficerSostavPerson tmp = new OficerSostavPerson();
            tmp.setFirstName(currentPerson.getFirstName());
            tmp.setLastName(currentPerson.getLastName());
            tmp.setThirdName(currentPerson.getThirdName());
            tmp.setOficerId(oficer.getId());

            oficerPersons.add(tmp);
        }
        return oficerPersons;
    }

    public Armia postArmia(OficerSostav kapitan) {
        Armia armia = new Armia();
        armia.setKapitan(kapitan);
        armiaRepository.save(armia);
        return armia;
    }

    public Brigada postBrigada(OficerSostav kapitan, Armia armia) {
        Brigada brigada = new Brigada();
        brigada.setKapitan(kapitan);
        brigada.setArmia(armia);
        brigadaRepository.save(brigada);
        return brigada;
    }

    public Divizia postDivizia(OficerSostav kapitan, Korpus korpus) {
        Divizia divizia = new Divizia();
        divizia.setKapitan(kapitan);
        divizia.setKorpus(korpus);
        diviziaRepository.save(divizia);
        return divizia;
    }

    public Korpus postKorpus(OficerSostav kapitan, Brigada brigada) {
        Korpus korpus = new Korpus();
        korpus.setKapitan(kapitan);
        korpus.setBrigada(brigada);
        korpusRepository.save(korpus);
        return korpus;
    }

    public Otdelenie postOtdelenie(Person kapitan, Vzvod vzvod) {
        Otdelenie otdelenie = new Otdelenie();
        otdelenie.setKapitan(kapitan);
        otdelenie.setVzvod(vzvod);
        otdelenieRepository.save(otdelenie);
        return otdelenie;
    }

    public Rota postRota(OficerSostav kapitan, VoinskayaChast voinskayaChast) {
        Rota rota = new Rota();
        rota.setKapitan(kapitan);
        rota.setVoinskayaChast(voinskayaChast);
        rotaRepository.save(rota);
        return rota;
    }

    public VoinskayaChast postVoinskayaChast(OficerSostav kapitan, Divizia divizia) {
        VoinskayaChast voinskayaChast = new VoinskayaChast();
        voinskayaChast.setKapitan(kapitan);
        voinskayaChast.setDivizia(divizia);
        voinskayaChastRepository.save(voinskayaChast);
        return voinskayaChast;
    }

    public Vzvod postVzvod(Person kapitan, Rota rota) {
        Vzvod vzvod = new Vzvod();
        vzvod.setKapitan(kapitan);
        vzvod.setRota(rota);
        vzvodRepository.save(vzvod);
        return vzvod;
    }

    public Armia getArmia(Integer id) {
        return armiaRepository.findById(id).get();
    }
    public Brigada getBrigada(Integer id) {
        return brigadaRepository.findById(id).get();
    }
    public Divizia getDivizia(Integer id) {
        return diviziaRepository.findById(id).get();
    }
    public Korpus getKorpus(Integer id) {
        return korpusRepository.findById(id).get();
    }
    public Otdelenie getOtdelenie(Integer id) {
        return otdelenieRepository.findById(id).get();
    }
    public Rota getRota(Integer id) {
        return rotaRepository.findById(id).get();
    }
    public VoinskayaChast getVoinskayaChast(Integer id) {
        return voinskayaChastRepository.findById(id).get();
    }
    public Vzvod getVzvod(Integer id) {
        return vzvodRepository.findById(id).get();
    }

    public List<Armia> getArmii() { return armiaRepository.findAll(); };
    public List<Brigada> getBrigadi() { return brigadaRepository.findAll(); };
    public List<Divizia> getDivizii() { return diviziaRepository.findAll(); };
    public List<Korpus> getKorpusi() { return korpusRepository.findAll(); };
    public List<Otdelenie> getOtdelenia() { return otdelenieRepository.findAll(); };
    public List<Rota> getRoti() { return rotaRepository.findAll(); };
    public List<VoinskayaChast> getVoinskayaChasti() { return voinskayaChastRepository.findAll(); };
    public List<Vzvod> getVzvodi() { return vzvodRepository.findAll(); };
}

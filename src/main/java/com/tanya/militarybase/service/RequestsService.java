package com.tanya.militarybase.service;

import com.tanya.militarybase.dao.podrazdelenia_repo.*;
import com.tanya.militarybase.model.podrazdelenia.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RequestsService {

    private final ArmiaRepository armiaRepository;
    private final BrigadaRepository brigadaRepository;
    private final KorpusRepository korpusRepository;
    private final DiviziaRepository diviziaRepository;
    private final VoinskayaChastRepository voinskayaChastRepository;
    private final RotaRepository rotaRepository;
    private final VzvodRepository vzvodRepository;
    private final OtdelenieRepository otdelenieRepository;

    public List<VoinskayaChast> findChastByArmia(Armia armia) {
        List<Brigada> brigadaList = brigadaRepository.findAllByArmia(armia);
        List<VoinskayaChast> allVoinskayaChastList = new ArrayList<VoinskayaChast>();
        for (Brigada brigada : brigadaList) {
            List<Korpus> korpusList = korpusRepository.findAllByBrigada(brigada);
            for (Korpus korpus : korpusList) {
                List<Divizia> diviziaList = diviziaRepository.findAllByKorpus(korpus);
                for (Divizia divizia : diviziaList) {
                    List<VoinskayaChast> voinskayaChastList = voinskayaChastRepository.findAllByDivizia(divizia);
                    allVoinskayaChastList.addAll(voinskayaChastList);
                }
            }
        }
        return allVoinskayaChastList;
    }

    public List<VoinskayaChast> findChastByDivizia(Divizia divizia) {
        return voinskayaChastRepository.findAllByDivizia(divizia);
    }

    public List<VoinskayaChast> findChastByKorpus(Korpus korpus) {
        List<VoinskayaChast> allVoinskayaChastList = new ArrayList<VoinskayaChast>();
        List<Divizia> diviziaList = diviziaRepository.findAllByKorpus(korpus);
        for (Divizia divizia : diviziaList) {
            List<VoinskayaChast> voinskayaChastList = voinskayaChastRepository.findAllByDivizia(divizia);
            allVoinskayaChastList.addAll(voinskayaChastList);
        }
        return allVoinskayaChastList;
    }
}

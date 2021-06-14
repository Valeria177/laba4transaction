package ru.laba.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.laba.training.persist.Model.Programm;
import ru.laba.training.persist.Model.User;
import ru.laba.training.persist.ProgrammRepository;
import ru.laba.training.persist.UserRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProgramService implements IProgramService{

    @Autowired
    private ProgrammRepository programmRepository;


    @Override
    public boolean create(Programm p) {
        p.setCountOFsubscribers(0);
        programmRepository.save(p);
        return true;
    }

    @Override
    public Programm findAuto() {
        return programmRepository.findauto();
    }

    @Override
    public Programm getOne(int id) {
        return programmRepository.getOne(id);
    }

    @Override
    public List<Programm> findForIndex(String type) {
       List<Programm> programms = new ArrayList<Programm>();
        if (type!=null)
            programms=programmRepository.findByType(type);
        else
            programms=programmRepository.findAll();
        return programms;
    }

    @Override
    public List<Programm> findForCreator(String type, User user) {
        List<Programm> programms = new ArrayList<Programm>();
        if (type!=null)
            programms=programmRepository.findByTypeForCreator(type, user.getId());
        else
            programms=user.getProgramms();
        return programms;
    }


}

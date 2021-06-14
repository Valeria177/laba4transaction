package ru.laba.training.service;

import ru.laba.training.persist.Model.Programm;
import ru.laba.training.persist.Model.User;

import java.util.List;

public interface IProgramService {
    boolean create(Programm p);
    Programm findAuto();
    Programm getOne(int id);
    List<Programm> findForIndex(String type);
    List<Programm> findForCreator(String type, User user);
}

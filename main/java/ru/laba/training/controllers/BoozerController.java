package ru.laba.training.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.laba.training.persist.*;
import ru.laba.training.persist.Model.*;
import ru.laba.training.service.ProgramService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BoozerController {

    private static final Logger logger = LoggerFactory.getLogger(BoozerController.class);

    @Autowired
    ProgramService programService;

    private ProgrammRepository repository;

    private final UserRepository userRepository;

    private ITrainRepository trainRepository;

    private ExerciserRepository exerciserRepository;

    private PersonalProgrammRepository personalProgrammRepository;

    private PersonalTrainRepository personalTrainRepository;

    private BoozerRepository boozerRepository;

    @Autowired
    public BoozerController(ProgrammRepository repository, UserRepository userRepository,
                            ITrainRepository trainRepository, ExerciserRepository exerciserRepository,
                            PersonalProgrammRepository personalProgrammRepository, PersonalTrainRepository personalTrainRepository,
                            BoozerRepository boozerRepository) {
        this.repository=repository;
        this.userRepository = userRepository;
        this.trainRepository= trainRepository;
        this.exerciserRepository = exerciserRepository;
        this.personalProgrammRepository = personalProgrammRepository;
        this.personalTrainRepository = personalTrainRepository;
        this.boozerRepository = boozerRepository;

    }
    //PROGRAMMS
    @GetMapping("/superBoozers")
    public String superBoozers(Model model, Principal principal) {

        model.addAttribute("boozers", boozerRepository.superBoozers(10));
        model.addAttribute("user", userRepository.findByUsername(principal.getName()).get());
        return "boozers";
    }

}

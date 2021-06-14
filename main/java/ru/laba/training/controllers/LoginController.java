package ru.laba.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.laba.training.persist.RoleRepository;
import ru.laba.training.service.UserRepr;
import ru.laba.training.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;
    private RoleRepository roleRepository;

    @Autowired
    public LoginController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }


    @GetMapping("/login")
    public String LoginPage() {

        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRepr());
        return "register";
    }


    @PostMapping("/register")
    public String registerNewUser(@Valid UserRepr userRepr, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register";
        }
        if (!userRepr.getPassword().equals(userRepr.getRepeatPassword())){
            bindingResult.rejectValue("password","","Пароли не совпадают");
        }
        userService.create(userRepr, roleRepository.getOne(1));
        return "redirect:/login";
    }
}

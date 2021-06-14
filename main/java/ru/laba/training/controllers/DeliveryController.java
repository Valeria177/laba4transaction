package ru.laba.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.laba.training.persist.TrainerRepository;
import ru.laba.training.persist.DeliveryRepository;
import ru.laba.training.service.ShipmentService;
import ru.laba.training.service.UserService;

@Controller
public class DeliveryController {

    private final UserService userService;
    private DeliveryRepository deliveryRepository;

    @Autowired
    ShipmentService shipmentService;
    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    public DeliveryController(UserService userService, DeliveryRepository deliveryRepository) {
        this.userService = userService;
        this.deliveryRepository = deliveryRepository;
    }


    @GetMapping("/delivery")
    public String LoginPage(Model model) {
        model.addAttribute("deliveries", deliveryRepository.findВуDeliveryForMostHeavyTrainer());
        return "DeliveryPage";
    }

    @PostMapping("/{id}/deleteDelivery")
    public String autoP(@PathVariable("id") int id){
        deliveryRepository.deleteById(id);
        return "redirect:/delivery";
    }

    @GetMapping("/load")
    public String load(Model model) {
        model.addAttribute("deliveries", deliveryRepository.findAll());
        model.addAttribute("trainer", trainerRepository.findAll());
        return "loadPage";
    }

    @PostMapping("/loadP")
    public String loadP(@ModelAttribute("id_delivery") int id_delivery, @ModelAttribute("id_trainer") int id_trainer){
        shipmentService.loading(id_delivery, id_trainer);
        return "redirect:/delivery";
    }
}

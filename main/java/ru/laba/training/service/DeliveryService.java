package ru.laba.training.service;
import org.springframework.stereotype.Service;
import ru.laba.training.persist.Model.Trainer;
import ru.laba.training.persist.Model.Delivery;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {

    public boolean loadingTruck(Delivery delivery, Trainer trainer) {
        List<Trainer> trainers = new ArrayList<Trainer>();
        trainers.add(trainer);
        if (delivery.getLoad() == null)
            delivery.setLoad(trainers);
        else
            delivery.getLoad().add(trainer);
        return true;
    }
}

package ru.laba.training.service;
import org.springframework.stereotype.Service;
import ru.laba.training.persist.Model.Trainer;
import ru.laba.training.persist.Model.Delivery;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    public boolean loadingCargo(Delivery delivery, Trainer trainer) {
        trainer.setCount(trainer.getCount()-1);
        List<Delivery> deliveries = new ArrayList<Delivery>();
        deliveries.add(delivery);
        if (trainer.getTrucks() == null)
            trainer.setTrucks(deliveries);
        else
            trainer.getTrucks().add(delivery);
        return true;
    }
}

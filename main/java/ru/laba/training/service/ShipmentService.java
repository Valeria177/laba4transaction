package ru.laba.training.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.laba.training.persist.Model.Delivery;
import ru.laba.training.persist.TrainerRepository;
import ru.laba.training.persist.Model.Trainer;
import ru.laba.training.persist.DeliveryRepository;

@Service
public class ShipmentService {
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    TrainerService trainerService;
    @Autowired
    DeliveryService deliveryService;


    @Transactional(rollbackFor = NullPointerException.class,
            isolation = Isolation.SERIALIZABLE)
    public boolean loading(int idT, int idC) {
        Delivery delivery = deliveryRepository.getOne(idT);
        Trainer trainer = trainerRepository.getOne(idC);
        if (delivery.getMax_weight()< trainer.getWeight() || trainer.getCount()<1) {
            return false;
        } else {
            deliveryService.loadingTruck(delivery, trainer);
            deliveryRepository.save(delivery);
            if (delivery.getID()==1)
                throw new NullPointerException();
            trainerService.loadingCargo(delivery, trainer);
            trainerRepository.save(trainer);
            return true;
        }
    }
}
package ru.laba.training.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.laba.training.persist.Model.Delivery;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    @Query("select d from Delivery d where d.max_weight>=(select max(t.weight) from Trainer t)")
    List<Delivery> findTrainerForMostHeavyDelivery();
}

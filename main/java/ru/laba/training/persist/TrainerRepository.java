package ru.laba.training.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.laba.training.persist.Model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}

package ru.laba.training.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<TrainProgram, Long> {
    List<TrainProgram> findByUserUsername(String username);
}

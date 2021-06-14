package ru.laba.training.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.laba.training.persist.Model.Boozer;
import ru.laba.training.persist.Model.Exercise;

import java.util.List;

public interface BoozerRepository extends JpaRepository<Exercise, Integer> {
    @Query("select b from Boozer b where b.capacity>= (select max(a.volume) from  Alckhol a where a.degerees>=:degrees) ")
    List<Boozer> superBoozers(@Param("degrees") int degrees);
}

package ru.laba.training.persist.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Boozer")
public class Boozer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "name")
    private  String name;

    @Column(name = "capacity")
    private  int capacity;

    @ManyToMany
    private List<Alckhol> alckhoList;

    public Boozer() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Alckhol> getAlckhoList() {
        return alckhoList;
    }

    public void setAlckhoList(List<Alckhol> alckhoList) {
        this.alckhoList = alckhoList;
    }
}

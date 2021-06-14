package ru.laba.training.persist.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false)
    private int ID;


    @Column(name = "name")
    private  String name;

    @Column(name = "weight")
    private  int weight;

    @Column(name = "count")
    private  int count;

    @ManyToMany
    private List<Delivery> deliveries;

    public Trainer() {
    }

    public Trainer(int ID, String name, int weight, int count, List<Delivery> deliveries) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.count = count;
        this.deliveries = deliveries;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Delivery> getTrucks() {
        return deliveries;
    }

    public void setTrucks(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

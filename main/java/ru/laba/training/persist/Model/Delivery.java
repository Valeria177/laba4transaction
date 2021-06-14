package ru.laba.training.persist.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false)
    private int ID;


    @Column(name = "name")
    private  String name;

    @Column(name = "max_weight")
    private  int max_weight;

    @ManyToMany
    private List<Trainer> load;

    public Delivery() {
    }

    public Delivery(int ID, String name, int max_weight, List<Trainer> load) {
        this.ID = ID;
        this.name = name;
        this.max_weight = max_weight;
        this.load = load;
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

    public int getMax_weight() {
        return max_weight;
    }

    public void setMax_weight(int max_weight) {
        this.max_weight = max_weight;
    }

    public List<Trainer> getLoad() {
        return load;
    }

    public void setLoad(List<Trainer> load) {
        this.load = load;
    }
}

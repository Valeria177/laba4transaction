package ru.laba.training.persist.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Alckhol")
public class Alckhol {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "name")
    private  String name;

    @Column(name = "volume")
    private  int volume;

    @Column(name = "degerees")
    private  int degerees;

    @ManyToMany
    private List<Boozer> boozers;

    public Alckhol() {
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getDegerees() {
        return degerees;
    }

    public void setDegerees(int degerees) {
        this.degerees = degerees;
    }

    public List<Boozer> getBoozers() {
        return boozers;
    }

    public void setBoozers(List<Boozer> boozers) {
        this.boozers = boozers;
    }
}

package com.example.faol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "degree")
public class Degree {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "duration")
    @NotNull(message = "Duration cannot be null")
    private String duration;

    @Column(name = "total_cost")
    @NotNull(message = "Total cost cannot be null")
    private Double total_cost;

    public Degree() {
    }

    public Degree(String name, String duration, Double total_cost) {
        this.name = name;
        this.duration = duration;
        this.total_cost = total_cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Double total_cost) {
        this.total_cost = total_cost;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", total_cost=" + total_cost +
                '}';
    }


}

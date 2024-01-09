package com.jakubzuchowicz.FCBService.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int goalsScored;

    private int goalsConceded;

    private int points;
}

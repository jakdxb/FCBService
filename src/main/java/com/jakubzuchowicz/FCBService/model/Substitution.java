package com.jakubzuchowicz.FCBService.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Substitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Player newPlayer;

    @OneToOne
    private Player changedPlayer;

    private String substitutionTime;
}

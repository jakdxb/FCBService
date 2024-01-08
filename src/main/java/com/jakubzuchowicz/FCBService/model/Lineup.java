package com.jakubzuchowicz.FCBService.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Entity
@Getter
@Setter
public class Lineup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "lineup", cascade = CascadeType.REMOVE)
    private List<Player> homeTeamLineup;

    @OneToMany(mappedBy = "lineup", cascade = CascadeType.REMOVE)
    private List<Player> awayTeamLineup;

    @OneToMany(mappedBy = "lineup", cascade = CascadeType.REMOVE)
    private List<Player> homeTeamBench;

    @OneToMany(mappedBy = "lineup", cascade = CascadeType.REMOVE)
    private List<Player> awayTeamBench;
}

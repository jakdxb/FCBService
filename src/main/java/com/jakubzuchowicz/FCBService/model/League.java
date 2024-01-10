package com.jakubzuchowicz.FCBService.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@Entity
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leagueId;

    private String leagueName;

    @OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE)
    private List<Team> teams;

    public void addTeam(Team team) {
        teams.add(team);
    }
}

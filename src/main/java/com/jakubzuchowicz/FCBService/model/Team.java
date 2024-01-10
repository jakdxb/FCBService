package com.jakubzuchowicz.FCBService.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String teamName;

    private int matches;

    private int wins;

    private int loses;

    private int draws;

    private int goalsScored;

    private int goalsConceded;

    private int points;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "league_id", referencedColumnName = "leagueId")
    private League league;
}

package com.jakubzuchowicz.FCBService.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Size(min = 3, max = 50, message = "nazwa zespolu musi byc dłuzsza od 3 znakow")
    private String teamName;

    @NotNull
    private int matches;

    @NotNull
    private int wins;

    @NotNull
    private int loses;

    @NotNull
    private int draws;

    @NotNull
    private int goalsScored;

    @NotNull
    private int goalsConceded;

    @NotNull
    private int points;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "league_id", referencedColumnName = "leagueId")
    private League league;
}

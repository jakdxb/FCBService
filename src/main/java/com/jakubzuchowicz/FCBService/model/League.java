package com.jakubzuchowicz.FCBService.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leagueId;

    @NotNull
    @Size(min = 3, max = 50, message = "nazwa ligi musi byc dłuzsza od 3 znakow")
    private String leagueName;

    @OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE)
    private List<Team> teams;

    public void addTeam(Team team) {
        teams.add(team);
    }
}

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
    private String leagueId;

    @OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE)
    private List<Team> teams;
}

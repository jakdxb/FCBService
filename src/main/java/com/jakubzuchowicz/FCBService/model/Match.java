package com.jakubzuchowicz.FCBService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String homeTeam;

    private String awayTeam;

    private String homeTeamLogoUrl;

    private String awayTeamLogoUrl;

    private int homeTeamScore;

    private int awayTeamScore;

    private LocalDateTime date;
}

package com.jakubzuchowicz.FCBService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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


    @NotNull
    @Size(min = 3, max = 50, message = "nazwa zespolu musi byc dłuzsza od 3 znakow")
    private String homeTeam;

    @NotNull
    @Size(min = 3, max = 50, message = "nazwa zespolu musi byc dłuzsza od 3 znakow")
    private String awayTeam;

    @NotNull
    private String homeTeamLogoUrl;

    @NotNull
    private String awayTeamLogoUrl;

    @NotNull
    private int homeTeamScore;

    @NotNull
    private int awayTeamScore;

    private LocalDateTime date;
}

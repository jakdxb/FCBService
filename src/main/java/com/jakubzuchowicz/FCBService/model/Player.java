package com.jakubzuchowicz.FCBService.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Getter
@Setter
@Entity
public class Player {
    @Id
    private Long jerseyNumber;

    @NotNull
    @Size(min = 2, max = 50, message = "imie musi byc dłuzsza od 2 znakow")
    private String name;

    @NotNull
    @Size(min = 2, max = 50, message = "nazwisko musi byc dłuzsza od 3 znakow")
    private String lastName;

    @NotNull
    private String position;

    @NotNull
    private int height;

    @NotNull
    private int goals;

    @NotNull
    private int assists;

    @NotNull
    private int matches;
}

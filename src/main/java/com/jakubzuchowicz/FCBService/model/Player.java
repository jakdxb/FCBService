package com.jakubzuchowicz.FCBService.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Getter
@Setter
@Entity
public class Player {
    @Id
    private Long jerseyNumber;

    private String name;

    private String lastName;

    private String position;

    private int height;

    private int goals;

    private int assists;

    private int matches;
}

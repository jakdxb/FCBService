package com.jakubzuchowicz.FCBService.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Getter
@Setter
@Entity
public class Player {
    @Id
    private int jerseyNumber;

    private String name;

    private String lastName;

    private String position;

    private int height;

    private int goals = 0;

    private int assists = 0;
}

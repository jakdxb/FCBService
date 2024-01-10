package com.jakubzuchowicz.FCBService.controller;
import com.jakubzuchowicz.FCBService.model.Comment;
import com.jakubzuchowicz.FCBService.model.Team;
import com.jakubzuchowicz.FCBService.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) { this.teamService = teamService; }

    @PostMapping("/{leagueId}")
    public ResponseEntity<Team> saveComment(@RequestBody Team team, @PathVariable Long leagueId) {
        Team savedTeam = teamService.addTeam(team, leagueId);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }




}

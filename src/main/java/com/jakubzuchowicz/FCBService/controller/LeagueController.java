package com.jakubzuchowicz.FCBService.controller;
import com.jakubzuchowicz.FCBService.model.Article;
import com.jakubzuchowicz.FCBService.model.League;
import com.jakubzuchowicz.FCBService.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/api/league")
public class LeagueController {

    private final LeagueService leagueService;
    @Autowired
    public LeagueController(LeagueService leagueService) { this.leagueService = leagueService; }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable Long id) {
        League league = leagueService.findLeagueById(id);
        if (league != null) {
            return new ResponseEntity<>(league, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<League> addLeague(@RequestBody League newLeague) {
        League savedLeague = leagueService.addLeague(newLeague);
        return new ResponseEntity<>(savedLeague, HttpStatus.CREATED);
    }


}

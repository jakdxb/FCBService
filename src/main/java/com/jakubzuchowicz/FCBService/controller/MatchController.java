package com.jakubzuchowicz.FCBService.controller;

import com.jakubzuchowicz.FCBService.model.Match;
import com.jakubzuchowicz.FCBService.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<Match> addMatch(@RequestBody Match newMatch) {
        Match addedMatch = matchService.addMatch(newMatch);
        return new ResponseEntity<>(addedMatch, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> matches = matchService.getAllMatches();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Match match = matchService.getMatchById(id);
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        Match updated = matchService.updateMatch(id, updatedMatch);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>("Mecz usunięty pomyślnie", HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Match>> getThreeLatestMatches() {
        List<Match> latestMatches = matchService.getThreeLatestMatches();
        return new ResponseEntity<>(latestMatches, HttpStatus.OK);
    }
}

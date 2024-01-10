package com.jakubzuchowicz.FCBService.service;
import com.jakubzuchowicz.FCBService.model.League;
import com.jakubzuchowicz.FCBService.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;
    @Autowired
    LeagueService(LeagueRepository leagueRepository){ this.leagueRepository = leagueRepository; }

    public League findLeagueById(Long id){ return leagueRepository.findById(id).orElse(null); }

    public List<League> getLeagues() { return leagueRepository.findAll(); }

    public League addLeague(League newLeague) {
        if(newLeague == null) {
            throw new IllegalArgumentException("Nowa liga nie moze byc pusta");
        }
        return leagueRepository.save(newLeague);
    }


}


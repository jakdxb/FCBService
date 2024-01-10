package com.jakubzuchowicz.FCBService.service;
import com.jakubzuchowicz.FCBService.model.Team;
import com.jakubzuchowicz.FCBService.model.League;
import com.jakubzuchowicz.FCBService.repository.TeamRepository;
import com.jakubzuchowicz.FCBService.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;



    @Autowired
    public TeamService(TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    public Team addTeam(Team team, Long leagueId) {
        League league = leagueRepository.findById(leagueId).orElse(null);
        team.setLeague(league);
        league.addTeam(team);
        leagueRepository.save(league);
        return teamRepository.save(team);

    }

}

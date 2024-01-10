package com.jakubzuchowicz.FCBService.service;
import com.jakubzuchowicz.FCBService.model.Team;
import com.jakubzuchowicz.FCBService.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) { this.teamRepository = teamRepository; }

    public Team addTeam(Team team) { return teamRepository.save(team); }
}

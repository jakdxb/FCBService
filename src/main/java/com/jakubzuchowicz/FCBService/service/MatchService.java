package com.jakubzuchowicz.FCBService.service;

import com.jakubzuchowicz.FCBService.model.Match;
import com.jakubzuchowicz.FCBService.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match addMatch(Match newMatch) {
        return matchRepository.save(newMatch);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public Match updateMatch(Long matchId, Match updatedMatch) {
        Match existingMatch = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException("Mecz o podanym ID nie istnieje"));

        existingMatch.setHomeTeam(updatedMatch.getHomeTeam());
        existingMatch.setAwayTeam(updatedMatch.getAwayTeam());
        existingMatch.setHomeTeamLogoUrl(updatedMatch.getHomeTeamLogoUrl());
        existingMatch.setAwayTeamLogoUrl(updatedMatch.getAwayTeamLogoUrl());
        existingMatch.setHomeTeamScore(updatedMatch.getHomeTeamScore());
        existingMatch.setAwayTeamScore(updatedMatch.getAwayTeamScore());
        existingMatch.setDate(updatedMatch.getDate());

        return matchRepository.save(existingMatch);
    }

    public void deleteMatch(Long matchId) {
        if (!matchRepository.existsById(matchId)) {
            throw new IllegalArgumentException("Mecz o podanym ID nie istnieje");
        }
        matchRepository.deleteById(matchId);
    }

    public List<Match> getThreeLatestMatches() {
        Sort sort = Sort.by(Sort.Direction.DESC, "date");
        return matchRepository.findTop3By(sort);
    }

}


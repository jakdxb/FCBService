package com.jakubzuchowicz.FCBService.service;
import com.jakubzuchowicz.FCBService.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public StudyService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


}

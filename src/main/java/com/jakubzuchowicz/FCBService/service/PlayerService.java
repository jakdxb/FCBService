package com.jakubzuchowicz.FCBService.service;
import com.jakubzuchowicz.FCBService.model.Player;
import com.jakubzuchowicz.FCBService.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player findPlayerById(Long playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }

    public Player addPlayer(Player newPlayer) {
        if (newPlayer == null) {
            throw new IllegalArgumentException("Nowy zawodnik nie może być null");
        }
        if (playerRepository.existsById(newPlayer.getJerseyNumber())) {
            throw new IllegalArgumentException("Gracz o podanym numerze koszulki już istnieje");
        }
        return playerRepository.save(newPlayer);
    }

    public void deletePlayer(Long playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new IllegalArgumentException("Zawodnik o podanym ID nie istnieje");
        }
        playerRepository.deleteById(playerId);
    }

    public Player updatePlayer(Long playerId, Player updatedPlayer) {
        // Sprawdzanie czy zawodnik o podanym ID istnieje
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Zawodnik o podanym ID nie istnieje"));

        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setLastName(updatedPlayer.getLastName());
        existingPlayer.setPosition(updatedPlayer.getPosition());
        existingPlayer.setHeight(updatedPlayer.getHeight());

        return playerRepository.save(existingPlayer);
    }




}

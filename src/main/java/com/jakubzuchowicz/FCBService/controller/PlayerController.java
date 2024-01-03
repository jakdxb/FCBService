package com.jakubzuchowicz.FCBService.controller;
import com.jakubzuchowicz.FCBService.model.Player;
import com.jakubzuchowicz.FCBService.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.findPlayerById(id);

        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addPlayer")
    public ResponseEntity<String> addPlayer(@RequestBody Player newPlayer) {
        try {
            Player addedPlayer = playerService.addPlayer(newPlayer);
            return new ResponseEntity<>("Zawodnik dodany pomyślnie", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePlayer/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        try {
            playerService.deletePlayer(id);
            return new ResponseEntity<>("Zawodnik usunięty pomyślnie", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePlayer/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        try {
            Player updatedPlayerResult = playerService.updatePlayer(id, updatedPlayer);
            return new ResponseEntity<>("Zawodnik zaktualizowany pomyślnie", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}

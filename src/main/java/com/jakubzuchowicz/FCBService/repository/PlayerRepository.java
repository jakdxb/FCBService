package com.jakubzuchowicz.FCBService.repository;
import com.jakubzuchowicz.FCBService.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}

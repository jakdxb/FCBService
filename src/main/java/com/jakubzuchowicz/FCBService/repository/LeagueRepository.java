package com.jakubzuchowicz.FCBService.repository;

import com.jakubzuchowicz.FCBService.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long>{

}

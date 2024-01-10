package com.jakubzuchowicz.FCBService.repository;

import com.jakubzuchowicz.FCBService.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}

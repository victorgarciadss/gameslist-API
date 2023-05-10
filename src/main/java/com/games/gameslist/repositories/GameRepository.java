package com.games.gameslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.gameslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}

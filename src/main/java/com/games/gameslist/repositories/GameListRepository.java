package com.games.gameslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.gameslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}

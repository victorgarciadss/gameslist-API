package com.games.gameslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.gameslist.dto.GameMinDTO;
import com.games.gameslist.entities.Game;
import com.games.gameslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;
    
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();

        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        
        return dto;
    }
}

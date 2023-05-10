package com.games.gameslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.games.gameslist.dto.GameListDTO;
import com.games.gameslist.entities.GameList;
import com.games.gameslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();

        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        
        return dto;
    }

    // @Transactional(readOnly = true)
    // public GameDTO findById(Long id){
    //     Game result = gameRepository.findById(id).get();
    //     GameDTO dto = new GameDTO(result);
        
    //     return dto;
    // }
}

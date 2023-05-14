package com.games.gameslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.games.gameslist.dto.GameListDTO;
import com.games.gameslist.entities.GameList;
import com.games.gameslist.projections.GameMinProjection;
import com.games.gameslist.repositories.GameListRepository;
import com.games.gameslist.repositories.GameRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();

        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        
        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min;
        int max;
        
        if(sourceIndex < destinationIndex){
            min = sourceIndex;
            max = destinationIndex;
        }
        else{
            min = destinationIndex;
            max = sourceIndex;
        }

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }

    // @Transactional(readOnly = true)
    // public GameDTO findById(Long id){
    //     Game result = gameRepository.findById(id).get();
    //     GameDTO dto = new GameDTO(result);
        
    //     return dto;
    // }
}

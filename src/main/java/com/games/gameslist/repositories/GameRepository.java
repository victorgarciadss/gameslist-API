package com.games.gameslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.games.gameslist.entities.Game;
import com.games.gameslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
    
    @Query(nativeQuery = true, value = """
		SELECT games.id, games.title, games.game_year AS gameYear, games.img_url AS imgUrl,
		games.short_description AS shortDescription, belonging.position
		FROM games
		INNER JOIN belonging ON games.id = belonging.game_id
		WHERE belonging.list_id = :listId
		ORDER BY belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}

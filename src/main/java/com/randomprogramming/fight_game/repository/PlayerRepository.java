package com.randomprogramming.fight_game.repository;

import com.randomprogramming.fight_game.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    Player findPlayerByUsername(String username);

    Player findPlayerByEmail(String email);
}

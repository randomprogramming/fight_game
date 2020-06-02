package com.randomprogramming.fight_game.repository;

import com.randomprogramming.fight_game.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}

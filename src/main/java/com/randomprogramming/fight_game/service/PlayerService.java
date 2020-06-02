package com.randomprogramming.fight_game.service;

import com.randomprogramming.fight_game.entity.Player;
import com.randomprogramming.fight_game.model.PlayerModel;
import com.randomprogramming.fight_game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public Player findPlayerByUsername(String username) {
        return playerRepository.findPlayerByUsername(username);
    }

    public Player registerPlayer(PlayerModel playerModel) throws Exception{
        //TODO: Register player
        return new Player();
    }
}

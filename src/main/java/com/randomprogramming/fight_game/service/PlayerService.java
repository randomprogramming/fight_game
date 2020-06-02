package com.randomprogramming.fight_game.service;

import com.randomprogramming.fight_game.entity.Player;
import com.randomprogramming.fight_game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public Player findPlayerByUsername(String username){
        return playerRepository.findPlayerByUsername(username);
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        //returns a list of authorities that the user has
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}

package com.randomprogramming.fight_game.service;

import com.randomprogramming.fight_game.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlayerDetailsService implements UserDetailsService {
    @Autowired
    PlayerService playerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player loadedPlayer = playerService.findPlayerByUsername(username);

        //if loadedPlayer is null, the username doesn't exist
        if(loadedPlayer == null) {
            throw new UsernameNotFoundException("Username " + username + " was not found.");
        } else {
            return new User(loadedPlayer.getUsername(),
                            loadedPlayer.getPassword(),
                            loadedPlayer.isEnabled(),
                            true, true, true,
                            playerService.getAuthorities(loadedPlayer.getRole()));
        }
    }
}

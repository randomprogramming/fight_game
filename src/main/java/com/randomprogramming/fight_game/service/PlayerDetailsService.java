package com.randomprogramming.fight_game.service;

import com.randomprogramming.fight_game.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class PlayerDetailsService implements UserDetailsService {
    @Autowired
    PlayerService playerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player loadedPlayer = playerService.findPlayerByUsername(username);

        //if loadedPlayer is null, the username doesn't exist
        if (loadedPlayer == null) {
            throw new UsernameNotFoundException("Username " + username + " was not found.");
        } else {
            return new User(loadedPlayer.getUsername(),
                    loadedPlayer.getPassword(),
                    loadedPlayer.isEnabled(),
                    true, true, true,
                    getAuthorities(loadedPlayer.getRole()));
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        //returns a list of authorities that the user has
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}

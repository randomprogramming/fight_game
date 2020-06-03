package com.randomprogramming.fight_game.service;

import com.randomprogramming.fight_game.defaults.PlayerDefaults;
import com.randomprogramming.fight_game.entity.Player;
import com.randomprogramming.fight_game.exception.EmailInUseException;
import com.randomprogramming.fight_game.exception.PasswordNotMatchingException;
import com.randomprogramming.fight_game.exception.UsernameInUseException;
import com.randomprogramming.fight_game.model.PlayerModel;
import com.randomprogramming.fight_game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public Player findPlayerByUsername(String username) {
        return playerRepository.findPlayerByUsername(username);
    }


    public boolean registerPlayer(PlayerModel playerModel) throws PasswordNotMatchingException, UsernameInUseException, EmailInUseException {
        // return true if player registered successfully
        // return false if registration failed
        // TODO: Check if password and email are valid before registration
        if (playerRepository.findPlayerByUsername(playerModel.getUsername()) != null)
            throw new UsernameInUseException("Player with the username " + playerModel.getUsername() + " already exists.");
        if (playerRepository.findPlayerByEmail(playerModel.getEmail()) != null)
            throw new EmailInUseException("Player with the email " + playerModel.getEmail() + " already exists.");
        if (!playerModel.getPassword().equals(playerModel.getRepeatedPassword()))
            throw new PasswordNotMatchingException("Entered passwords don't match!");

        // create the new registered player
        Player registeredPlayer = new Player(PlayerDefaults.ROLE_USER, playerModel.getUsername(),
                passwordEncoder.encode(playerModel.getPassword()), playerModel.getEmail(),
                PlayerDefaults.ATTACK, PlayerDefaults.DEFENSE,
                PlayerDefaults.VITALITY, PlayerDefaults.DEXTERITY,
                PlayerDefaults.STAMINA, PlayerDefaults.GOLD,
                PlayerDefaults.EMERALD, PlayerDefaults.HEALTH,
                PlayerDefaults.HEALTH, PlayerDefaults.LEVEL);

        boolean isRegistrationSuccess = true;
        try {
            // since we have `nullable = false` columns in the Player class,
            // saving a player can throw an exception
            playerRepository.save(registeredPlayer);
        } catch (Exception e) {
            isRegistrationSuccess = false;
        }
        return isRegistrationSuccess;
    }
}

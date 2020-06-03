package com.randomprogramming.fight_game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerModel {
    // this is the model of a player which we receive when the user is trying to register
    // this gets turned into a Player object and saved into the database
    private final String username;
    private final String email;
    private final String password;
    private final String repeatedPassword;
}

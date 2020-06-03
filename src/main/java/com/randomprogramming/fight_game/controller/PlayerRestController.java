package com.randomprogramming.fight_game.controller;

import com.randomprogramming.fight_game.exception.EmailInUseException;
import com.randomprogramming.fight_game.exception.PasswordNotMatchingException;
import com.randomprogramming.fight_game.exception.UsernameInUseException;
import com.randomprogramming.fight_game.model.PlayerModel;
import com.randomprogramming.fight_game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerRestController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/api/register")
    @CrossOrigin
    public void registerPlayer(@RequestBody PlayerModel playerModel){
        System.out.println(playerModel.getPassword());
        System.out.println(playerModel.getRepeatedPassword());
        try{
            if(playerService.registerPlayer(playerModel)){
                System.out.println("Registration yes");
            } else {
                System.out.println("Registration no");
            }
        } catch (PasswordNotMatchingException | UsernameInUseException | EmailInUseException e){
            System.out.println(e.getMessage());
        }
    }
}

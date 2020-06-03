package com.randomprogramming.fight_game.controller;

import com.randomprogramming.fight_game.exception.EmailInUseException;
import com.randomprogramming.fight_game.exception.PasswordNotMatchingException;
import com.randomprogramming.fight_game.exception.UsernameInUseException;
import com.randomprogramming.fight_game.model.PlayerModel;
import com.randomprogramming.fight_game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerRestController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/api/register")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> registerPlayer(@RequestBody PlayerModel playerModel) {
        ResponseEntity<?> response;
        try {
            if (playerService.registerPlayer(playerModel)) {
                response = new ResponseEntity<>("Registration successful.", HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (PasswordNotMatchingException | UsernameInUseException | EmailInUseException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return response;
    }
}

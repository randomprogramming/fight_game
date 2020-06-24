package com.randomprogramming.fight_game.controller;

import com.randomprogramming.fight_game.entity.Player;
import com.randomprogramming.fight_game.exception.EmailInUseException;
import com.randomprogramming.fight_game.exception.PasswordNotMatchingException;
import com.randomprogramming.fight_game.exception.UsernameInUseException;
import com.randomprogramming.fight_game.model.PlayerModel;
import com.randomprogramming.fight_game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class PlayerRestController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/api/me")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> getMe(Principal principal) {
        // we don't have to check if the user exists because principal will be empty or null in that case and
        // we just return a bad request
        return principal == null || principal.getName().length() == 0 ?
                new ResponseEntity<>("Player is not authenticated.", HttpStatus.NOT_ACCEPTABLE) :
                new ResponseEntity<>(playerService.findPlayerByUsername(principal.getName()), HttpStatus.OK);
    }

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

    @GetMapping("/api/findplayerbyusername/{username}")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> findPlayerByUsername(@PathVariable String username) {
        ResponseEntity<?> response;
        try {
            Player foundPlayer = playerService.findPlayerByUsername(username);
            response = new ResponseEntity<>(foundPlayer, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return response;
    }
}

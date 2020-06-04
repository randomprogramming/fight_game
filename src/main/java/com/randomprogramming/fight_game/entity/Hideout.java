package com.randomprogramming.fight_game.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Hideout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    TODO: Add the rest of the stuff
}

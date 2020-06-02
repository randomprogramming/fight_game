package com.randomprogramming.fight_game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonIgnore //ignore sensitive info when returning an entity
    private String password;

    @Column(nullable = false)
    @JsonIgnore //ignore sensitive info when returning an entity
    private String email;

    @Column(nullable = false)
    private int attack;

    @Column(nullable = false)
    private int defense;

    @Column(nullable = false)
    private int vitality;

    @Column(nullable = false)
    private int dexterity;

    @Column(nullable = false)
    private int stamina;

    @Column(nullable = false)
    private Long gold;

    @Column(nullable = false)
    private Long emerald;

    @Column(nullable = false)
    private Long currentHealth;

    @Column(nullable = false)
    private Long maxHealth;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private int fightCount;

    @Column(nullable = false)
    private int winCount;

    @Column(nullable = false)
    private int loseCount;

    //TODO: Give proper type
    private short guild;
    private short hideout;

    @ManyToMany
    //TODO: Give proper JoinColumn annotation
    private List<Item> inventory;
}
package com.randomprogramming.fight_game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private boolean isEnabled;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @JsonIgnore //ignore sensitive info when returning an entity
    private String password;

    @Column(nullable = false, unique = true)
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
    @ManyToOne
    private Guild guild;

    @OneToOne
    private Hideout hideout;

    @ManyToMany
    //TODO: Give proper JoinColumn annotation
    private List<Item> inventory;

    public Player(String role, String username, String password,
                  String email, int attack, int defense,
                  int vitality, int dexterity, int stamina,
                  Long gold, Long emerald, Long currentHealth,
                  Long maxHealth, int level) {
        this.isEnabled = true;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.attack = attack;
        this.defense = defense;
        this.vitality = vitality;
        this.dexterity = dexterity;
        this.stamina = stamina;
        this.gold = gold;
        this.emerald = emerald;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.level = level;
        this.fightCount = 0;
        this.winCount = 0;
        this.loseCount = 0;
    }
}
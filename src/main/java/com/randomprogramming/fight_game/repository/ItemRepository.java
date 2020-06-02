package com.randomprogramming.fight_game.repository;

import com.randomprogramming.fight_game.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}

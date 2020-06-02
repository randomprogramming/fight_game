package com.randomprogramming.fight_game.repository;

import com.randomprogramming.fight_game.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}

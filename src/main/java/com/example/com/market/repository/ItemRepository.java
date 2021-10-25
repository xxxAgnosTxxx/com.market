package com.example.com.market.repository;

import com.example.com.market.models.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Items, Integer> {
}
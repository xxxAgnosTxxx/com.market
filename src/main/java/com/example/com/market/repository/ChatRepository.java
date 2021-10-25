package com.example.com.market.repository;

import com.example.com.market.models.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Integer> {
}

package com.portalNoticias.Repo;

import com.portalNoticias.Models.LogItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogItemRepository extends MongoRepository<LogItem, Long> {
}

package com.example.model.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Marcos Barbero
 */
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String> {
}

package com.example.model.repository.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Marcos Barbero
 */
public interface SecondaryRepository extends MongoRepository<SecondaryMongoObject, String> {
}

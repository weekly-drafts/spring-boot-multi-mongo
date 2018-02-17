package com.marcosbarbero.wd.multiplemongo.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Marcos Barbero
 */
public interface PrimaryRepository extends MongoRepository<PrimaryModel, String> {
}

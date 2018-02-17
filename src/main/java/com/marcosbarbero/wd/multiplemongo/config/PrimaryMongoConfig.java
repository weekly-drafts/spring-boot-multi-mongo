package com.marcosbarbero.wd.multiplemongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static com.marcosbarbero.wd.multiplemongo.config.PrimaryMongoConfig.MONGO_TEMPLATE;

/**
 * @author Marcos Barbero
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.marcosbarbero.wd.multiplemongo.repository.primary",
        mongoTemplateRef = MONGO_TEMPLATE)
public class PrimaryMongoConfig {

    protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}

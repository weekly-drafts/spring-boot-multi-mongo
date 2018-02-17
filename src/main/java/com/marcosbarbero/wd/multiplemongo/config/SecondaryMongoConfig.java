package com.marcosbarbero.wd.multiplemongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static com.marcosbarbero.wd.multiplemongo.config.SecondaryMongoConfig.MONGO_TEMPLATE;

/**
 * @author Marcos Barbero
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.marcosbarbero.wd.multiplemongo.repository.secondary",
        mongoTemplateRef = MONGO_TEMPLATE)
public class SecondaryMongoConfig {

    protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}

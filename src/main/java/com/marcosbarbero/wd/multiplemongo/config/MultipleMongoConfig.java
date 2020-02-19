package com.marcosbarbero.wd.multiplemongo.config;

import com.mongodb.ConnectionString;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Marcos Barbero
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {

    private final MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
    }

    @Bean(name = SecondaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate() throws Exception {
        return new MongoTemplate(secondaryFactory(this.mongoProperties.getSecondary()));
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(final MongoProperties mongo) throws Exception {
        ConnectionString conn = new ConnectionString(buildConnectionString(mongo));
        return new SimpleMongoClientDbFactory(conn);
    }

    @Bean
    public MongoDbFactory secondaryFactory(final MongoProperties mongo) throws Exception {
        ConnectionString conn = new ConnectionString(buildConnectionString(mongo));
        return new SimpleMongoClientDbFactory(conn);
    }

    /**
     * Builds connectionString with credentials
     * 
     * @param mongo
     * @return String with the connection information
     */
    private String buildConnectionString(MongoProperties mongo) {
        String prefex = "mongodb://";
        String con = new StringBuffer(prefex).append(mongo.getUsername()).append(":").append(mongo.getPassword())
                .append("@").append(mongo.getHost()).append(":").append(mongo.getPort()).append("/")
                .append(mongo.getDatabase()).toString();
        log.debug("connection String: " + con);
        return con;
    }

}

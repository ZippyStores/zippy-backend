package com.zippystore.inventory.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration class customizes the behavior of Jackson, which is the
 * library used for JSON serialization and deserialization in Spring Boot.
 */
@Configuration
public class JacksonConfig {

    /**
     * This method defines a bean for the ObjectMapper, which is the core class
     * used by Jackson to map Java objects to JSON and vice versa.
     *
     * The customization here disables the feature `FAIL_ON_EMPTY_BEANS`, which
     * by default causes Jackson to throw an exception if it encounters an empty
     * or uninitialized object during serialization.
     *
     * By setting it to 'false', Jackson will ignore empty beans (such as Hibernate
     * proxies) and proceed with the serialization without failing.
     *
     * @return customized ObjectMapper instance
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Disables failure on empty beans, allowing Hibernate proxies or other
        // uninitialized objects to be serialized without errors.
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return objectMapper;
    }
}

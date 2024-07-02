package org.delivery.api.config.jpa;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("org.delivery.db")
@EnableJpaRepositories("org.delivery.db")
public class JpaConfig {
}

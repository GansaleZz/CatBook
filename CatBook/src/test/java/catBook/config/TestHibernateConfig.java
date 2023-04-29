package catBook.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("catBook.*")
@ComponentScan(basePackages = {"catBook.main.hibernate.*", "genesis.hibernate.*"})
@EnableJpaRepositories("catBook.*")
public class TestHibernateConfig {
    private final ApplicationContext context;

    public TestHibernateConfig(ApplicationContext context) {
        this.context = context;
    }
}

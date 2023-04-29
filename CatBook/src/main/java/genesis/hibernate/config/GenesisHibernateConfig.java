package genesis.hibernate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Default Hibernate config.
 *
 * @author GansaleZz
 */
@Configuration
@ComponentScan("genesis.*")
@EnableJpaRepositories("genesis.hibernate.*")
public class GenesisHibernateConfig {

}

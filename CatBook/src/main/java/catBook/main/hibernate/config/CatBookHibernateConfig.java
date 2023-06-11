package catBook.main.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author GansaleZz
 */
@Configuration
@EnableJpaRepositories("catBook.main.hibernate.DAO.*")
public class CatBookHibernateConfig {

}

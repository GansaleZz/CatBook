package catBook;

import catBook.main.hibernate.config.CatBookHibernateConfig;
import genesis.hibernate.config.GenesisHibernateConfig;
import liquibase.CustomCreateTableChange;
import liquibase.Scope;
import liquibase.change.ChangeFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Application starter.
 *
 * @author GansaleZz
 */
@SpringBootApplication
@Import({GenesisHibernateConfig.class, CatBookHibernateConfig.class})
@EntityScan(basePackages = {"catBook.main.bean", "catBook.api.*", "genesis.api"})
@ComponentScan("catBook.*")
public class ApplicationStarter implements WebMvcConfigurer {

    public static void main(String[] args) {
        Scope.getCurrentScope().getSingleton(ChangeFactory.class).register(new CustomCreateTableChange());

        SpringApplication.run(ApplicationStarter.class, args);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //                                                                                   //
    //                                  CUSTOM BEANS                                     //
    //                                                                                   //
    ///////////////////////////////////////////////////////////////////////////////////////
}

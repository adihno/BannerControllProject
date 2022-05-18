package pl.coderslab.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;


@Configuration
@ComponentScan(basePackages = "pl.coderslab")

@EnableJpaRepositories(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

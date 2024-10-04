package ru.pickme.backend.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import ru.pickme.backend.validation.UserValidator;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {

    private final UserValidator userValidator;

    // Внедряем наш валидатор через конструктор
    public RestRepositoryConfig(@Qualifier("beforeCreateUserValidator") UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", userValidator);
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    }
}

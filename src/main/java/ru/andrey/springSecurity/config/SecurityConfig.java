package ru.andrey.springSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.andrey.springSecurity.security.AuthProviderImpl;
import ru.andrey.springSecurity.services.PersonDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    //    private final AuthProviderImpl authProvider;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    //Настраивает аутенфикацию
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.authenticationProvider(authProvider);
        auth.userDetailsService(personDetailsService); //TODO
    }

    @Bean
    public PasswordEncoder getPassword() {
        return NoOpPasswordEncoder.getInstance();
    }
}

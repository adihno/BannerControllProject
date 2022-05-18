package pl.coderslab.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.entity.Admin;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private Admin admin;
    @Autowired
    AdminDao adminDao;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication
        List<Admin> admins = adminDao.getAllAdmins();
        for (int i = 0; i <admins.size(); i++) {
            auth.inMemoryAuthentication()
                    .withUser(admins.get(i).getEmail())
                    .password(passwordEncoder().encode(admins.get(i).getPassword()))
                    .roles("USER");
        }


//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password("test123")
//                .roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .defaultSuccessUrl("/dashboard",true)
                .permitAll();
    }
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}

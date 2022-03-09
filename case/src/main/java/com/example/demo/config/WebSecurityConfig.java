package com.example.demo.config;

import com.example.demo.service.user.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*Cài đặt cách lấy thông tin UserDetail, cơ chế Encode pass..*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home").permitAll() //Khi login bằng URL /login thì khi thành công sẽ vào '/student
                .and()
                .authorizeRequests()
                .antMatchers("/home", "/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.png","**/*.mp4").permitAll() /*không cần xác thực.*/
                .antMatchers("/customer/customers").hasRole("USER")
                .antMatchers("/customer/**").hasRole("ADMIN")
                .antMatchers("/employee/employees").hasRole("USER")
                .antMatchers("/employee/**").hasRole("ADMIN")
                .antMatchers("/service/services").hasRole("USER")
                .antMatchers("/service/**").hasRole("ADMIN")
                .anyRequest().authenticated() // Tất cả request gọi lên server đều phải login
        .and().logout().logoutSuccessUrl("/login");

        /*Cấu hình remember me*/
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60 * 60 * 24);

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

    }

    /*Cấu hình nơi lưu thông tin login*/
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }

}

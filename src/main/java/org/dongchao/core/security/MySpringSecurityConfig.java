package org.dongchao.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 自定义spring security 的配置，覆盖spring boot 的自动配置
 * @Profile("production") 要求运行时激活 production Profile(即application-production.yml)，这样才能应用该配置。如果
 * production Profile没有激活，就会忽略该配置，而此时缺少其他用于覆盖的安全配置，于是应用自动配置的安全配置。
 * 设置 spring.profiles.active=dev属性就能激活Profile,即激活当前bean的配置
 * Created by zhaodongchao on 2017/5/5.
 */
@Profile("dev")
@Configuration
@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> userRepository.findDcUserByUsername(username));
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/book/**").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true");
    }
}

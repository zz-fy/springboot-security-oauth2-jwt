package cn.zfy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Classname WebSecurityConfiguration
 * @Description Spring security 配置类
 * @Date 2020/10/14 14:49
 * @Created by zfy
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    /**
     * 密码编码器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
        //基于内存存储用户信息
       /* auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("123")).authorities("p1") //登录用户admin密码123拥有“p1”权限
                .and()
                .withUser("zfy").password(passwordEncoder().encode("456")).authorities("p2");*/
    }


    /**
     * 安全拦截机制
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/auth/login").permitAll()
                .antMatchers("/api/**").authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
       /* http.authorizeRequests()
                .antMatchers("/api/p/p1").hasAnyAuthority("p1")//权限控制
                .antMatchers("/api/p/p2").hasAnyAuthority("p2")
                .antMatchers("/api/p/**").authenticated()//所有/api/p开头的请求都必须经过认证
                .anyRequest().permitAll()//其余的可以直接访问
                .and()
                .formLogin().permitAll();*/
    }
}

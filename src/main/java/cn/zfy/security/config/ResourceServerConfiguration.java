package cn.zfy.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Classname ResourceServerConfiguration
 * @Description TODO
 * @Date 2020/10/15 11:05
 * @Created by zfy
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    //资源id
    public static final String RESOURCE_ID = "res";

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore)
                .resourceId(RESOURCE_ID)
                .stateless(false);
    }

   @Override
   public void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/api/auth/login").permitAll()
               .anyRequest().authenticated()
       ;

   }
}

package cn.zfy.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Classname JwtTokenConfig
 * @Description jwt令牌服务，实现生成jwt格式的令牌
 * @Date 2020/10/16 11:16
 * @Created by zfy
 */
@Configuration
public class JwtTokenConfig {

    private static final String SIGN_KEY = "auth123";

    @Autowired
    private CustomAccessTokenConverter customAccessTokenConverter;


    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setAccessTokenConverter(customAccessTokenConverter);
        converter.setSigningKey(SIGN_KEY);
        return converter;
    }
}

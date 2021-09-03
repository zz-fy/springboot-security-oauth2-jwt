package cn.zfy.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description
 * @Created by zfy
 */
@RestController
@RequestMapping("/api")
public class HelloController {


    @Autowired
    private JwtTokenStore jwtTokenStore;


    @RequestMapping("/p/p1")
    @PreAuthorize("hasAnyAuthority('SystemContent')")
    public String p1() {
        return "访问p1下面的资源";
    }

    @RequestMapping("/p/p2")
    public String p2() {
        OAuth2AuthenticationDetails details
                = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
       /* OAuth2AccessToken accessToken = jwtTokenStore
                .readAccessToken(details.getTokenValue());
        Map<String, Object> additionalInformation = accessToken.getAdditionalInformation();
        additionalInformation.forEach((k, v) -> {
            System.out.println(k + "----->" + v);
        });*/
        Map<String, Object> extraInfo = (Map<String, Object>)details.getDecodedDetails();
        extraInfo.forEach((k, v) -> {
            System.out.println(k + "----->" + v);
        });
        return "访p2下面的资源";
    }

    @RequestMapping("/s/s1")
    public String s1() {
        return "访问s1下面的资源";
    }
}

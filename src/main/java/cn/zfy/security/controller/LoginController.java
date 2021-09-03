package cn.zfy.security.controller;

import cn.zfy.security.ResultModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/10/19 9:16
 * @Created by zfy
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Value("${security.oauth2.client.access-token-uri}")
    private String accessTokenUri;

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/login")
    public ResultModel login(@RequestBody Map<String,String> loginParams,@RequestHeader HttpHeaders httpHeaders) throws UnsupportedEncodingException {
        // 构造 post的body内容（要post的内容，按需定义）
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.set("grant_type", "password");
        String username = loginParams.get("username");
        paramsMap.set("username", username);
        String password = loginParams.get("password");
        paramsMap.set("client_id", clientId);
        paramsMap.set("client_secret", clientSecret);
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            paramsMap.set("password", new String(decoder.decodeBuffer(password)));
        } catch (IOException e) {
            return ResultModel.fail("密码有误");
        }
        // 使用客户端的请求头,发起请求
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 强制移除 原来的请求头,防止token失效
        httpHeaders.remove(HttpHeaders.AUTHORIZATION);
        //构造请求实体和头
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(paramsMap, httpHeaders);
        JSONObject authInfo = null;
        try {
            authInfo = restTemplate.postForObject(accessTokenUri, request, JSONObject.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                byte[] bs = e.getResponseBodyAsByteArray();
                String msg = new String(bs, "utf-8");
                Map<String, String> mm = (Map<String, String>) JSON.parse(msg);
                return ResultModel.fail(mm.get("error_description"));
            } else {
                return ResultModel.fail("登录失败");
            }
        }
        JSONObject jsonObject = new JSONObject(authInfo);
        String jwt = jsonObject.getString("access_token");
        Map<String, String> jwtMap = new HashMap<>();
        jwtMap.put("jwt", jwt);
        return ResultModel.success(jwtMap);
    }
}

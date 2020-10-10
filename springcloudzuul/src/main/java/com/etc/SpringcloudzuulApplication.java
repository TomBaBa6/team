package com.etc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import  org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableRedisHttpSession
public class SpringcloudzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudzuulApplication.class, args);
    }


    @Bean
    public  LoginFilter getloginfilter(){
        return  new LoginFilter();
    }


    @Bean
    public TokenFilter getTokenfileter(){
        return  new TokenFilter();
    }

    @Bean
    public  PasswordFilter getpasswordfileter(){
        return new PasswordFilter();
    }

}

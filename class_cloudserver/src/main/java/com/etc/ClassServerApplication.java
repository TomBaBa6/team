package com.etc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SocketUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ClassServerApplication {

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

/*
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> containerCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory container) {
                int port = SocketUtils.findAvailableTcpPort(8001, 8999);// 随机端口号范围
                container.setPort(port);
                System.getProperties().put("server.port", port);
            }
        };
    }
*/


    public static void main(String[] args) {
        SpringApplication.run(ClassServerApplication.class, args);
    }

}

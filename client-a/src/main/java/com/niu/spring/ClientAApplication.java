package com.niu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 *
 * @version 1.0 [2021/03/23 14:33]
 * @author [nza]
 * @createTime [2021/03/23 14:33]
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientAApplication.class, args);
    }
}

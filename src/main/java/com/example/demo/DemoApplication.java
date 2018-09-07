package com.example.demo;

import com.example.demo.config.ClusterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ClusterConfig cc = new ClusterConfig();
//        new TestFabricApplication().show();
//        new Test().show();
        cc.showResource();
    }
}

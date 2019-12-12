package com.scrotify.matrimony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication

public class MatrimonyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatrimonyApplication.class, args);
    }

}

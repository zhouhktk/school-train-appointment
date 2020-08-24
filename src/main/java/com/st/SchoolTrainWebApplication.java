package com.st;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.st.dao")
@SpringBootApplication
public class SchoolTrainWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolTrainWebApplication.class, args);
    }

}

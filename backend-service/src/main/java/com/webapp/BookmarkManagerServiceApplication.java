package com.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BookmarkManagerServiceApplication {

    private static Logger logger = LoggerFactory.getLogger(BookmarkManagerServiceApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(BookmarkManagerServiceApplication.class, args);

        logger.info("************************************************************");
        logger.info("************BOOKMARK MANAGER STARTED SUCCESSFULLY***********");
        logger.info("************************************************************");

    }

}


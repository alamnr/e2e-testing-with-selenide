package com.e2e.selenide.e2e_testing_with_selenide;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;



@Testcontainers
public class ModuleContainerTest {

    @Container
    static PostgreSQLContainer database = new PostgreSQLContainer<>("postgres:12")
                                                    .withUsername("duke")
                                                    .withPassword("secret")
                                                    //.withInitScript("config/INIT.sql")
                                                    .withDatabaseName("testcontainers");

    @Test
    void testPostgresSqlModule(){
        System.out.println(database.getJdbcUrl());
        System.out.println(database.getTestQueryString());

    }


    
}

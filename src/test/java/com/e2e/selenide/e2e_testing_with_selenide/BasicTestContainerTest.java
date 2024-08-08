package com.e2e.selenide.e2e_testing_with_selenide;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;


@Testcontainers
public class BasicTestContainerTest {
    @Container
    static GenericContainer<?> keyCloak = new GenericContainer<>(DockerImageName
                                                .parse("keycloak/keycloak"))
                                                //.parse("quay.io/keycloak/keycloak:latest"))
                                                .waitingFor(Wait.forHttp("/auth").forStatusCode(200))
                                                .withExposedPorts(8080)
                                                //.withClasspathResourceMapping("/config/test.txt","/tmp/test.txt",BindMode.READ_WRITE)
                                                .withEnv(Map.of(
                                                        "KEYCLOAK_USER", "testcontainers",
                                                        "KEYCLOAK_PASSWORD", "testcontainers",
                                                        "DB_VENDOR", "h2"    ));

    @Test
    void testWithKeycloak() throws IOException , InterruptedException {
        org.testcontainers.containers.Container.ExecResult execResult = keyCloak.execInContainer("/bin/sh","-c", "echo \"Admin user is $KEYCLOAK_USER\"");
        System.out.println("Result : "+ execResult.getStdout());
        System.out.println("Keycloak is running on port: "+ keyCloak.getMappedPort(8080));
        
    }

}
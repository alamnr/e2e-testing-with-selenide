package com.e2e.selenide.e2e_testing_with_selenide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import com.codeborne.selenide.junit5.ScreenShooterExtension;

//@Disabled("Failing on CI, to be fixed")
@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
public class BookStoreWT {

    @LocalServerPort 
    private Integer port;
    
    @RegisterExtension
    static ScreenShooterExtension extension =  new ScreenShooterExtension().to("target/selenide");

    @BeforeAll
    static void configureChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        Configuration.browserCapabilities = chromeOptions;
    }

    @Test
    void shouldDisplayBooks()    {
        Configuration.reportsFolder = "target/selenide";
        Configuration.baseUrl = "http://localhost:" + port;

        open("/book-store");

        $(By.id("all-books")).shouldNot(Condition.exist);

        screenshot("pre-book-fetch");

        $(By.id("fetch-books")).click();
        $(By.id("all-books")).shouldBe(Condition.visible);
        $$(By.tagName("h1")).shouldHave(CollectionCondition.size(2));


    }

    
}

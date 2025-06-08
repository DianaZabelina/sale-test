package test.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

// Базовый тестовый класс

public class BaseTest {
    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://navisale.ru/";
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }
}
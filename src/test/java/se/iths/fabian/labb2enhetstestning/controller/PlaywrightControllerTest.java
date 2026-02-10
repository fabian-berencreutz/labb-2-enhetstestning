package se.iths.fabian.labb2enhetstestning.controller;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlaywrightControllerTest {

    @LocalServerPort
    private int port;

    private Playwright playwright;
    private Browser browser;

    @BeforeAll
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    void testPageTitleIsCorrect() {
        Page page = browser.newPage();
        page.navigate("http://localhost:" + port + "/balance");
        assertTrue(page.title().equals("Bankomat Saldo"));
        page.close();
    }

    @Test
    void testBalanceIsDisplayed() {
        Page page = browser.newPage();
        page.navigate("http://localhost:" + port + "/balance");
        assertTrue(page.locator("body").innerText().contains("Aktuellt saldo: 0 kr"));
        page.close();
    }
}
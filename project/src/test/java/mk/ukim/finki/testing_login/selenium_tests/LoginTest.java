package mk.ukim.finki.testing_login.selenium_tests;

import mk.ukim.finki.testing_login.po.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static org.testng.Assert.*;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    // 1. invalid credentials -> error message
    // 2. empty username -> error message
    // 3. login successful
    @Test
    public void invalidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("erob", "123");
        assertFalse(loginPage.isLoggedIn());
    }

    @Test
    public void invalidCredentialsLoginMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("erob", "123");
        assertFalse(loginPage.isLoggedIn());
        System.out.println(driver.findElement(By
                .xpath("//*[@id=\"js-flash-container\"]/div/div")).getText());
    }

    @Test
    public void emptyUsernameLoginMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("", "");
        assertFalse(loginPage.isLoggedIn());
        System.out.println(driver.findElement(By
                .xpath("//*[@id=\"js-flash-container\"]/div/div")).getText());
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("TheBore", "setiebam123");
        assertTrue(loginPage.isLoggedIn());
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/C:/Users/boris/Documents/GitHub/Library-Spring-React/Testing_Login/src/main/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}

package mk.ukim.finki.testing_login.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://github.com/login");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field"))).isDisplayed();
    }

    //  username id: login_field
    //  password id: password
    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(5000);
        // login button click
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[12]")).click();
        Thread.sleep(5000);
    }

    // check if user is logged in, i.e. the (github) logo is visible
    public boolean isLoggedIn() throws InterruptedException {
        Thread.sleep(5000);
        return !driver.findElements(By.xpath("/html/body/div[1]/header/div[1]/a")).isEmpty();
    }

}

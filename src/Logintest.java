import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logintest extends GeneralWebDriver {

    @Test(priority = 1)
    void Login_Valid() {

        WebElement username = driver.findElement(By.cssSelector("[placeholder='Username']"));
        username.sendKeys(Userinfo.name);

        WebElement userpass = driver.findElement(By.cssSelector("[placeholder='Password']"));
        userpass.sendKeys(Userinfo.pass);

        WebElement loginbtn = driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]"));
        loginbtn.click();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement welcome = driver.findElement(By.xpath("//user-image[@biggeravatar=\"true\"]//following-sibling::div//span"));

        Assert.assertTrue(welcome.getText().contains("Welcome"));


    }

    @Test(priority = 2)
    void logout() {


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement acceptall = driver.findElement(By.className("consent-give"));
        acceptall.click();

        WebElement menu = driver.findElement(By.xpath("//*[@class=\"ng-star-inserted\"]//div[@fxlayout=\"row\"]//following::button[9]"));
        menu.click();


        WebElement signout = driver.findElement(By.xpath("//*[@class=\"mat-menu-content ng-tns-c186-5\"]//button[5]"));
        signout.click();


    }

    @Test(priority = 3)
    void Login_InValid_1() {


        WebElement username = driver.findElement(By.cssSelector("[placeholder='Username']"));
        username.clear();
        username.sendKeys(Userinfo.name2);

        WebElement userpass = driver.findElement(By.cssSelector("[placeholder='Password']"));
        userpass.clear();
        userpass.sendKeys(Userinfo.pass2);

        WebElement loginbtn = driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]"));
        loginbtn.click();



        WebElement welcome = driver.findElement(By.cssSelector("[class=\"hot-toast-bar-base\"]"));

        Assert.assertTrue(welcome.isDisplayed());


    }

    @Test(priority = 4)
    void Login_InValid_2() {

        WebElement username = driver.findElement(By.cssSelector("[placeholder='Username']"));
        username.clear();
        username.sendKeys(Userinfo.name);

        WebElement userpass = driver.findElement(By.cssSelector("[placeholder='Password']"));
        userpass.clear();
        userpass.sendKeys(Userinfo.pass2);

        WebElement loginbtn = driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]"));
        loginbtn.click();


        WebElement welcome = driver.findElement(By.cssSelector("[class=\"hot-toast-bar-base\"]"));

        Assert.assertTrue(welcome.isDisplayed());

    }

    @Test(priority = 5)
    void Login_InValid_3() {

        WebElement username = driver.findElement(By.cssSelector("[placeholder='Username']"));
        username.clear();
        username.sendKeys(Userinfo.name2);

        WebElement userpass = driver.findElement(By.cssSelector("[placeholder='Password']"));
        userpass.clear();
        userpass.sendKeys(Userinfo.pass);

        WebElement loginbtn = driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]"));
        loginbtn.click();


        WebElement welcome = driver.findElement(By.cssSelector("[class=\"hot-toast-bar-base\"]"));

        Assert.assertTrue(welcome.isDisplayed());

    }
}

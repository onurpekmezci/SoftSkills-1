import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Edittest extends GeneralWebDriver {


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

        Assert.assertTrue(welcome.getText().contains("Welcome") || welcome.getText().contains("Merhaba"));


    }

    @Test(priority = 2)
    void editprofile() {

        settingsclick();
        WebElement language = driver.findElement(By.xpath("//*[@class=\"mat-tab-body-wrapper\"]//following::mat-form-field[4]"));
        language.click();
        if (language.getText().contains("English"))
            englang(language);
        else turlang(language);
        //  WebElement savebtn = driver.findElement(By.cssSelector("ms-save-button[class=\"ng-star-inserted\"] button"));
        // savebtn.click();
    }

    @Test(priority = 3)
    void editnotice() {



        WebElement notices = driver.findElement(By.cssSelector("[aria-controls=\"mat-tab-content-0-1\"]"));
        notices.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement answersub = driver.findElement(By.cssSelector("[id=\"mat-slide-toggle-14-input\"]"));

        Actions act= new Actions(driver);
        act.doubleClick(answersub).build().perform();
     WebElement savebtn = driver.findElement(By.cssSelector("ms-save-button[class=\"ng-star-inserted\"] button"));
        savebtn.click();
    }

    static void settingsclick() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement acceptall = driver.findElement(By.className("consent-give"));
        acceptall.click();

        WebElement menu = driver.findElement(By.xpath("//*[@class=\"ng-star-inserted\"]//div[@fxlayout=\"row\"]//following::button[9]"));
        menu.click();

        WebElement settings = driver.findElement(By.xpath("//*[@class=\"mat-menu-content ng-tns-c186-5\"]//button[4]"));
        settings.click();

    }

    static void englang(WebElement elm) {

        WebElement turkish = driver.findElement(By.xpath("//span[@class=\"mat-option-text\"]//following::span[contains(text(),'Turkish')]"));

        WebElement english = driver.findElement(By.xpath("//span[@class=\"mat-option-text\"]"));


        if (elm.getText().contains("English")) turkish.click();
        else english.click();


    }

    static void turlang(WebElement elm) {

        WebElement turkish = driver.findElement(By.xpath("//span[@class=\"mat-option-text\"]//following::span[contains(text(),'Türkçe')]"));

        WebElement english = driver.findElement(By.xpath("//span[@class=\"mat-option-text\"]"));


        if (elm.getText().contains("İngilizce")) turkish.click();
        else english.click();

    }
}

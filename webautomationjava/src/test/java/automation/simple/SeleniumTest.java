package automation.simple;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {
    WebDriver driver;
    @Test
    public void loginTest(){
        //open browser
        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        String txtActualBerhasilLogin = driver.findElement(By.xpath("//h2[contains(.,'Secure Area')]")).getText();
        String txtExpectedBerhasilogin = "Secure Area";

        Assert.assertEquals(txtActualBerhasilLogin,txtExpectedBerhasilogin);
        //Close browser
        driver.quit();

    }

    @Test
    public void loginTestFailedPass(){
        //open browser
        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        String txtErrorFailedPass = driver.findElement(By.xpath("//div[@id='flash']")).getText();
//        String txtExpectedBerhasilogin = "Secure Area";
        System.out.println(txtErrorFailedPass);
        //Close browser
        driver.quit();

    }

}

package TugasWebAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

@Test
public class YopmailTest {
    WebDriver driver;
    public void iFrameTest(){
        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //memasukkan kata di kolom pencarian
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("automationtest");
        driver.findElement(By.xpath("//button[@class='md']")).click(); //klik tombol

        //memilih email
        driver.switchTo().frame("ifinbox"); //switch iframe chat
        driver.findElement(By.xpath("//div[@class='mctn']/div[2]/button[@class='lm']")).click(); //Klik email dipilih
        driver.switchTo().defaultContent(); //keluar iframe

        //verifikasi pengirim dari email yang dipilih
        driver.switchTo().frame("ifmail"); //masuk iframe bagian isi email
        String extractContent = driver.findElement(By.xpath("//div[@id='mail']")).getText(); //mengambil kata dari Xpath
        System.out.println(extractContent);
        System.out.println("--------------berhasil----------------");
        driver.quit();

    }
}

package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class MtsTest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void intDriver() {
        driver.get("https://www.mts.by/");

        // Жмем отмену в куки окне, если появится
        try {
            By by = By.className("cookie__buttons");
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).findElement(By.xpath("button[2]")).click();
        }
        catch (Exception e) {
        }
    }

    @Test
    public void testPaymentBlockTitle() {
        WebElement pw = driver.findElement(By.className("pay__wrapper"));
        WebElement title = pw.findElement(By.xpath("h2"));
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
    }

    @Test
    public void testPaymentPartnersCount()
    {
        WebElement pw = driver.findElement(By.className("pay__wrapper"));
        List<WebElement> logos = pw.findElement(By.className("pay__partners")).findElements(By.xpath("ul/li"));
        Assertions.assertEquals(5, logos.size());
    }

    @Test
    public void testAboutLink()
    {
        WebElement pw = driver.findElement(By.className("pay__wrapper"));
        WebElement about = pw.findElement(By.xpath("a"));
        Assertions.assertEquals("Подробнее о сервисе", about.getText());
        about.click();
        driver.navigate().back();
    }

    @Test
    public void testPaymentSubmission() {
        WebElement payform = driver.findElement(By.id("pay-connection"));
        payform.findElement(By.id("connection-phone")).sendKeys("297777777");
        payform.findElement(By.id("connection-sum")).sendKeys("10");
        payform.findElement(By.xpath("button")).click();

        try {
            sleep(5000);
        }
        catch (InterruptedException e) {
        }
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}

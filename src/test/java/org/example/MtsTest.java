package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", new MtsMainPage(driver).getPaymentBlockTitle());
    }

    @Test
    public void testPaymentPartners() {
        Assertions.assertEquals(5, new MtsMainPage(driver).getPayPartnersCount());
    }

    @Test
    public void testAboutLink() {
        new MtsMainPage(driver).clickAboutLink();
    }

    @Test
    public void testPaymentSubmission() {
        MtsPaymentFrame mpf = new MtsMainPage(driver).submitPayment( "297777777", "10");

        List<String> caps = mpf.getCaptions();
        Assertions.assertEquals("10.00 BYN", caps.get(0));
        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", caps.get(1));
        Assertions.assertEquals("Номер карты", caps.get(2));
        Assertions.assertEquals("Срок действия", caps.get(3));
        Assertions.assertEquals("CVC", caps.get(4));
        Assertions.assertEquals("Имя держателя (как на карте)", caps.get(5));
        Assertions.assertEquals("Оплатить 10.00 BYN", caps.get(6));

        Assertions.assertEquals(5, mpf.getPayPartnersCount());
    }

    @Test
    public void testPayFormCaptions() {
        MtsMainPage mainPage = new MtsMainPage(driver);

        mainPage.choosePaymentSelector(0);
        Sleep(1000);
        List<String> caps0 = mainPage.getPaymentCaptions();
        Assertions.assertEquals("Услуги связи", caps0.get(0));
        Assertions.assertEquals("Номер телефона", caps0.get(1));
        Assertions.assertEquals("Сумма", caps0.get(2));
        Assertions.assertEquals("E-mail для отправки чека", caps0.get(3));

        mainPage.choosePaymentSelector(1);
        Sleep(1000);
        List<String> caps1 = mainPage.getPaymentCaptions();
        Assertions.assertEquals("Домашний интернет", caps1.get(0));
        Assertions.assertEquals("Номер абонента", caps1.get(1));
        Assertions.assertEquals("Сумма", caps1.get(2));
        Assertions.assertEquals("E-mail для отправки чека", caps1.get(3));

        mainPage.choosePaymentSelector(2);
        Sleep(1000);
        List<String> caps2 = mainPage.getPaymentCaptions();
        Assertions.assertEquals("Рассрочка", caps2.get(0));
        Assertions.assertEquals("Номер счета на 44", caps2.get(1));
        Assertions.assertEquals("Сумма", caps2.get(2));
        Assertions.assertEquals("E-mail для отправки чека", caps2.get(3));

        mainPage.choosePaymentSelector(3);
        Sleep(1000);
        List<String> caps3 = mainPage.getPaymentCaptions();
        Assertions.assertEquals("Задолженность", caps3.get(0));
        Assertions.assertEquals("Номер счета на 2073", caps3.get(1));
        Assertions.assertEquals("Сумма", caps3.get(2));
        Assertions.assertEquals("E-mail для отправки чека", caps3.get(3));
    }

    static public void Sleep(int ms)
    {
        try {
            sleep(ms);
        }
        catch (InterruptedException e) {
        }
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MtsPaymentFrame {
    private final WebDriver driver;
    private final By sectLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section");
    public MtsPaymentFrame(WebDriver driver) {
        this.driver = driver;
        // Ждем подгрузки секции и находим ее
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(sectLocator));
        WebElement sect = driver.findElement(sectLocator);

        // Ждем, когда подгрузятся значения
        WebElement titleSum = sect.findElement(By.xpath("div/div/div[1]/span[1]"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElement(titleSum, "BYN"));
    }
    public List<String> getCaptions() {
        // Собираем текстовые значения в массив
        ArrayList<String> txt = new ArrayList<>();

        String xpaths[] = {
                "div/div/div[1]/span[1]",
                "div/div/div[2]/span[1]",
                "div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label",
                "div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label",
                "div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label",
                "div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label",
                "div/app-card-page/div/div[1]/button",
        };
        WebElement sect = driver.findElement(sectLocator);
        for (String x: xpaths) {
            txt.add(sect.findElement(By.xpath(x)).getText());
        }
        return txt;
    }
    public int getPayPartnersCount() {
        WebElement sect = driver.findElement(sectLocator);
        return sect.findElements(By.xpath("div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img")).size() +
                sect.findElements(By.xpath("div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img")).size();
    }


}

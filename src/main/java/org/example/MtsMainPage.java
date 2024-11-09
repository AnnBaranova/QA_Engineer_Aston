package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MtsMainPage {
    private final By pwLocator = By.className("pay__wrapper");
    private final WebDriver driver;
    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPaymentBlockTitle() {
        WebElement pw = driver.findElement(pwLocator);
        WebElement title = pw.findElement(By.xpath("h2"));
        return title.getText();
    }
    public int getPayPartnersCount() {
        WebElement pw = driver.findElement(pwLocator);
        List<WebElement> logos = pw.findElement(By.className("pay__partners")).findElements(By.xpath("ul/li"));
        return logos.size();
    }
    public MtsMainPage clickAboutLink() {
        WebElement pw = driver.findElement(pwLocator);
        WebElement about = pw.findElement(By.xpath("a"));
        about.click();
        driver.navigate().back();
        return this;
    }
    public MtsPaymentFrame submitPayment(String phone, String sum) {
        WebElement payform = driver.findElement(By.id("pay-connection"));
        payform.findElement(By.id("connection-phone")).sendKeys("297777777");
        payform.findElement(By.id("connection-sum")).sendKeys("10");
        payform.findElement(By.xpath("button")).click();
        // Ждем подгрузки фрейма и переключаемся на него
        By frameLocator = By.xpath("/html/body/div[8]/div/iframe");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

        return new MtsPaymentFrame(driver);
    }
    public MtsMainPage clickPaymentSelectorBox() {
        WebElement btn = driver.findElement(By.className("pay__form")).findElement(By.xpath("div[1]/div[2]/button"));
        btn.click();
        return this;
    }
    public MtsMainPage choosePaymentSelector(int index) {
        WebElement list = driver.findElement(By.className("pay__form")).findElement(By.xpath("div[1]/div[2]/ul"));
        if (!list.isDisplayed()) {
            clickPaymentSelectorBox();
        }
        List<WebElement> items = list.findElements(By.xpath("li"));
        items.get(index).click();
        return this;
    }
    public List<String> getPaymentCaptions() {
        ArrayList<String> caps = new ArrayList<>();
        WebElement btn = driver.findElement(By.className("pay__form")).findElement(By.xpath("div[1]/div[2]/button"));
        caps.add(btn.findElement(By.xpath("span")).getText());
        List<WebElement> forms = driver.findElement(By.className("pay__forms")).findElements(By.xpath("form"));
        for (WebElement pf: forms) {
            if (pf.isDisplayed()) {
                for (WebElement w : pf.findElements(By.xpath("div"))) {
                    caps.add(w.findElement(By.xpath("input")).getAttribute("placeholder"));
                }
                break;
            }
        }
        return caps;
    }
}

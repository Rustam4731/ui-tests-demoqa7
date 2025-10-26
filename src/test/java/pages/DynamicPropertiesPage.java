package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicPropertiesPage extends BasePage {
    private final By enableAfterBtn = By.id("enableAfter");
    private final By colorChangeBtn = By.id("colorChange");
    private final By visibleAfterBtn = By.id("visibleAfter");

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/dynamic-properties");
    }

    public void waitForButtonToBeEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(enableAfterBtn));
    }

    public void waitForButtonToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleAfterBtn));
    }

    public boolean isEnableAfterButtonEnabled() {
        return driver.findElement(enableAfterBtn).isEnabled();
    }

    public boolean isVisibleAfterButtonDisplayed() {
        return isElementVisible(visibleAfterBtn);
    }

    public String getColorChangeButtonColor() {
        return driver.findElement(colorChangeBtn).getCssValue("color");
    }
}
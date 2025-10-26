package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsPage extends BasePage {
    private final By doubleClickBtn = By.id("doubleClickBtn");
    private final By rightClickBtn = By.id("rightClickBtn");
    private final By dynamicBtn = By.xpath("//button[text()='Click Me']");
    private final By dblMsg = By.id("doubleClickMessage");
    private final By rgtMsg = By.id("rightClickMessage");
    private final By dynMsg = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public void doubleClickButton() {
        WebElement btn = waitForElement(doubleClickBtn);
        actions().doubleClick(btn).perform();
    }

    public void rightClickButton() {
        WebElement btn = waitForElement(rightClickBtn);
        actions().contextClick(btn).perform();
    }

    public void dynamicClick() {
        click(dynamicBtn);
    }

    public boolean hasDoubleClickMessage() {
        return isElementVisible(dblMsg);
    }

    public boolean hasRightClickMessage() {
        return isElementVisible(rgtMsg);
    }

    public boolean hasDynamicClickMessage() {
        return isElementVisible(dynMsg);
    }

    public String getDoubleClickMessage() {
        return getText(dblMsg);
    }

    public String getRightClickMessage() {
        return getText(rgtMsg);
    }

    public String getDynamicClickMessage() {
        return getText(dynMsg);
    }
}
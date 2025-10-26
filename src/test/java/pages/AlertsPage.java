package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {
    private final By alertBtn = By.id("alertButton");
    private final By confirmBtn = By.id("confirmButton");
    private final By promptBtn = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/alerts");
    }

    public void openSimpleAlertAndAccept() {
        click(alertBtn);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void openConfirmAndDismiss() {
        click(confirmBtn);
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public void openPromptAndSend(String text) {
        click(promptBtn);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    public String getConfirmResult() {
        return getText(confirmResult);
    }

    public String getPromptResult() {
        return getText(promptResult);
    }
}
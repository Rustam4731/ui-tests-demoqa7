package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowsPage extends BasePage {
    private final By newTabBtn = By.id("tabButton");

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/browser-windows");
    }

    public void openNewTab() {
        String originalWindow = driver.getWindowHandle();
        click(newTabBtn);

        // Ждем появления новой вкладки
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Переключаемся на новую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public String getNewTabHeading() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }

    public void closeNewTabAndReturn() {
        String currentWindow = driver.getWindowHandle();
        driver.close();

        // Возвращаемся к оригинальному окну
        for (String windowHandle : driver.getWindowHandles()) {
            if (!currentWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
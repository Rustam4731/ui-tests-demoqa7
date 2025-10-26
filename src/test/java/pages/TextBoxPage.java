package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {
    private final By userName = By.id("userName");
    private final By userEmail = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By output = By.id("output");
    private final By emailField = By.cssSelector("#userEmail");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fillForm(String name, String email, String currentAddr, String permanentAddr) {
        type(userName, name);
        type(userEmail, email);
        type(currentAddress, currentAddr);
        type(permanentAddress, permanentAddr);
        click(submit);
    }

    public boolean isOutputVisible() {
        return isElementVisible(output);
    }

    public String getEmailFieldClass() {
        return driver.findElement(emailField).getAttribute("class");
    }

    public String getOutputText() {
        return getText(output);
    }
}
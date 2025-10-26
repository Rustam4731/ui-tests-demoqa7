package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadDownloadPage extends BasePage {
    private final By upload = By.id("uploadFile");
    private final By uploaded = By.id("uploadedFilePath");

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/upload-download");
    }

    public void uploadFile(String absolutePath) {
        driver.findElement(upload).sendKeys(absolutePath);
    }

    public String getUploadedFilePath() {
        return getText(uploaded);
    }
}
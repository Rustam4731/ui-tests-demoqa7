package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicPropertiesPage;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void shouldWaitForButtonToBeEnabled() {
        DynamicPropertiesPage page = new DynamicPropertiesPage(driver);
        page.open();

        page.waitForButtonToBeEnabled();
        Assert.assertTrue(page.isEnableAfterButtonEnabled(),
                "Кнопка должна стать кликабельной после ожидания");
    }

    @Test
    public void shouldWaitForButtonToBeVisible() {
        DynamicPropertiesPage page = new DynamicPropertiesPage(driver);
        page.open();

        page.waitForButtonToBeVisible();
        Assert.assertTrue(page.isVisibleAfterButtonDisplayed(),
                "Кнопка должна стать видимой после ожидания");
    }
}
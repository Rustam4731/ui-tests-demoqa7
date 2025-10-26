package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;

public class ButtonsTest extends BaseTest {

    @Test
    public void shouldShowDoubleClickMessage() {
        ButtonsPage page = new ButtonsPage(driver);
        page.open();
        page.doubleClickButton();

        Assert.assertTrue(page.hasDoubleClickMessage(), "Ожидалось сообщение после двойного клика");
        Assert.assertEquals(page.getDoubleClickMessage(), "You have done a double click");
    }

    @Test
    public void shouldShowRightClickMessage() {
        ButtonsPage page = new ButtonsPage(driver);
        page.open();
        page.rightClickButton();

        Assert.assertTrue(page.hasRightClickMessage(), "Ожидалось сообщение после правого клика");
        Assert.assertEquals(page.getRightClickMessage(), "You have done a right click");
    }

    @Test
    public void shouldShowDynamicClickMessage() {
        ButtonsPage page = new ButtonsPage(driver);
        page.open();
        page.dynamicClick();

        Assert.assertTrue(page.hasDynamicClickMessage(), "Ожидалось сообщение после динамического клика");
        Assert.assertEquals(page.getDynamicClickMessage(), "You have done a dynamic click");
    }
}
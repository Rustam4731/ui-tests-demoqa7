package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WindowsPage;

public class WindowsTest extends BaseTest {

    @Test
    public void shouldOpenNewTab() {
        WindowsPage page = new WindowsPage(driver);
        page.open();
        page.openNewTab();

        String heading = page.getNewTabHeading();
        Assert.assertEquals(heading, "This is a sample page",
                "Заголовок новой вкладки должен соответствовать ожидаемому");

        page.closeNewTabAndReturn();

        // Проверяем, что вернулись на исходную страницу
        Assert.assertTrue(driver.getCurrentUrl().contains("browser-windows"),
                "Должны вернуться на исходную страницу после закрытия вкладки");
    }
}
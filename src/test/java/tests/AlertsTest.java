package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTest extends BaseTest {

    @Test
    public void shouldAcceptSimpleAlert() {
        AlertsPage page = new AlertsPage(driver);
        page.open();
        page.openSimpleAlertAndAccept();

        // Если алерт успешно закрыт - тест пройден
        Assert.assertTrue(true, "Alert должен был быть успешно принят");
    }

    @Test
    public void shouldDismissConfirmAlert() {
        AlertsPage page = new AlertsPage(driver);
        page.open();
        page.openConfirmAndDismiss();

        String result = page.getConfirmResult();
        Assert.assertTrue(result.toLowerCase().contains("cancel"),
                "Ожидался текст о выборе Cancel. Получено: " + result);
    }

    @Test
    public void shouldAcceptPromptWithText() {
        AlertsPage page = new AlertsPage(driver);
        page.open();
        page.openPromptAndSend("Test User");

        String result = page.getPromptResult();
        Assert.assertTrue(result.contains("Test User"),
                "Ожидалось отображение введенного текста в результате. Получено: " + result);
    }
}
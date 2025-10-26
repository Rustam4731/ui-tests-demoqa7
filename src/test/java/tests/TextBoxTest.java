package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TextBoxTest extends BaseTest {

    @Test
    public void shouldSubmitValidData() {
        TextBoxPage page = new TextBoxPage(driver);
        page.open();
        page.fillForm("Ivan Petrov", "ivan.petrov@example.com", "Moscow, Red Square", "Saint Petersburg, Nevsky Prospect");

        Assert.assertTrue(page.isOutputVisible(), "Ожидалось появление блока вывода после отправки формы.");

        String outputText = page.getOutputText();
        Assert.assertTrue(outputText.contains("Ivan Petrov"), "В выводе должно содержаться имя");
        Assert.assertTrue(outputText.contains("ivan.petrov@example.com"), "В выводе должен содержаться email");
    }

    @Test
    public void shouldHighlightInvalidEmail() {
        TextBoxPage page = new TextBoxPage(driver);
        page.open();
        page.fillForm("Ivan Petrov", "not-an-email", "Moscow", "Saint Petersburg");

        String cssClass = page.getEmailFieldClass();
        Assert.assertTrue(cssClass.contains("field-error") || cssClass.contains("error"),
                "Ожидалось визуальное указание на невалидный email. Класс поля: " + cssClass);
    }
}
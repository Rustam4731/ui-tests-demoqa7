package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadDownloadPage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadTest extends BaseTest {

    @Test
    public void shouldUploadFile() {
        UploadDownloadPage page = new UploadDownloadPage(driver);
        page.open();

        // Создаем временный файл для загрузки
        Path tempFile;
        try {
            tempFile = java.nio.file.Files.createTempFile("testfile", ".txt");
            java.nio.file.Files.write(tempFile, "This is test content".getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Не удалось создать временный файл", e);
        }

        page.uploadFile(tempFile.toAbsolutePath().toString());

        String uploadedPath = page.getUploadedFilePath();
        Assert.assertTrue(uploadedPath.contains("testfile"),
                "В загруженном пути должно содержаться имя файла. Получено: " + uploadedPath);

        // Удаляем временный файл
        try {
            java.nio.file.Files.deleteIfExists(tempFile);
        } catch (Exception e) {
            // Игнорируем ошибку удаления
        }
    }
}
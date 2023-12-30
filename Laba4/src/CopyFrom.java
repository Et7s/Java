import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyFrom {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\Etos\\Desktop\\Паспорт\\2.txt";
        String destinationFilePath = "C:\\Users\\Etos\\Desktop\\Паспорт\\3.txt";

        try (
                FileInputStream fis = new FileInputStream(sourceFilePath);
                FileOutputStream fos = new FileOutputStream(destinationFilePath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}

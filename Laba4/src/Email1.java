import java.io.FileWriter;
import java.io.IOException;

class CustomEmail extends Exception {
    public CustomEmail(String message) {
        super(message);
    }
}

public class Email1 {
    public static void main(String[] args) {
        String email = "Hello_is@gmail.c2om";

        try {
            Email(email);
            System.out.println("Email корректен.");
        } catch (CustomEmail e) {
            logException(e);
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void Email(String email) throws CustomEmail {
        if (!email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}\\b")) {
            throw new CustomEmail("Недопустимый формат email-адреса: " + email);
        }
    }

    private static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("Error.txt", true)) {
            writer.write("Exception: " + e.getClass().getSimpleName() + "\n");
            writer.write("Message: " + e.getMessage() + "\n");
            writer.write("StackTrace: \n");
            for (StackTraceElement element : e.getStackTrace()) {
                writer.write("\t" + element.toString() + "\n");
            }
            writer.write("\n");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
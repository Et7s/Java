import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InteresnoPassword {
    public static void main(String[] args) {
        String text = "Danila123";
        Pattern pattern = Pattern.compile("(?=.*[a-zA-Z0-9]).{8,16}");
        Pattern pattern1 = Pattern.compile("(?=.*[A-Z]).{1,}");
        Pattern pattern2 = Pattern.compile("(?=.*[0-9]).{1,}");
        Matcher matcher = pattern.matcher(text);
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        if(matcher.matches() && matcher1.matches() && matcher2.matches()){
            System.out.println(true);
        } else if (!matcher.matches() && matcher1.matches() && matcher2.matches()) {
            System.out.println("Пароль должен быть длинной от 8 до 16 символов");
        }else if (matcher.matches() && !matcher1.matches() && matcher2.matches()) {
            System.out.println("Нет заглавной буквы");
        }else if (matcher.matches() && matcher1.matches() && !matcher2.matches()) {
            System.out.println("Нет цифр");
        }else if (matcher.matches() && !matcher1.matches() && !matcher2.matches()) {
            System.out.println("Нет заглавной буквы и нет цифр");
        }else if (!matcher.matches() && matcher1.matches() && !matcher2.matches()) {
            System.out.println("Пароль должен быть длинной от 8 до 16 символов и нет цифр");
        }else if (!matcher.matches() && !matcher1.matches() && matcher2.matches()) {
            System.out.println("Пароль должен быть длинной от 8 до 16 символов и нет заглавной буквы");
        }else{
            System.out.println("В пароле находиться символ,который не проходит проверку");
        }
    }

}

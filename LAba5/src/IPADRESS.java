import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPADRESS {
    public static void main(String[] args) {
        String text = "255.2.2.022";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()){
            System.out.println("IP-adress правильный");
        }else{
            System.out.println("Неправильно было введено IP");
        }
    }
}

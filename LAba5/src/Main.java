import java.util.regex.*;
public class Main {
    public static void main(String[] args) {
        String text = "hello i  2wanna 2.222playing fo0tball";
        Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d");
        Matcher matcher = pattern.matcher(text);
        Matcher matcher1 = pattern.matcher(text);
        if(matcher.find()){
            while (matcher1.find()){
                System.out.println(matcher1.group());
            }
        }else {
            System.out.println("Нет чисел в этой строке");
        }
    }
}
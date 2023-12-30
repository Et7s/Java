import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkHyperlink {
    public static void main(String[] args) {
        String text = "https://mtuci.ru/ - официальный сайт университета связи и информатики";
        Pattern pattern = Pattern.compile("(https?://\\S+)");
        Matcher matcher = pattern.matcher(text);
        Matcher matcher1 = pattern.matcher(text);
        StringBuilder replacedText = new StringBuilder();
        if (matcher1.find()) {
            while (matcher.find()) {
                String url = matcher.group();
                String replacement = url.replaceAll("https?://|\\/", "");
                matcher.appendReplacement(replacedText, replacement);
            }
            matcher.appendTail(replacedText);
            System.out.println(replacedText.toString());
        }else {
            System.out.println("Неправильно ввели адресс");
        }
    }
}

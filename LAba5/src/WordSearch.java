import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
    public static void main(String[] args){
        String text = "The side bar includes a Cheatsheet, full Reference, and Help." +
                "You can A also Save & Share with the Community and view patterns you create or favorite in My Patterns." +
                "Explore results with the Tools below. Replace & List output custom results."+
                "Details lists capture groups. Explain describes your expression in plain English.";
        Pattern pattern = Pattern.compile("\\ba[A-Za-z]*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        ///System.out.println(generateBrackets(1));
        ///System.out.println(generateBrackets(2));
        ///System.out.println(generateBrackets(3));


    }
    public static String nonRepeatable(String x){
        String result = new StringBuilder(x).reverse().toString();
        result = result.replaceAll("(.)(?=.*\\1)", "");
        result = new StringBuilder(result).reverse().toString();
        return result;
    }



}
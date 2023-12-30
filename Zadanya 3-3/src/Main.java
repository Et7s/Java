import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeper"));
        System.out.println(doesBlockkFit(1,3,5,4,5));
        System.out.println(doesBlockkFit(1,8,1,1,1));
        System.out.println(doesBlockkFit(1,2,2,1,1));
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println(countRoots(new int[] {1,-3,2}));
        System.out.println(countRoots(new int[] {2,5,2}));
        System.out.println(countRoots(new int[] {1,-6,9}));
        System.out.println(salesData(new String[][] {{"Apple","Shop1","Shop2","Shop3","Shop4"},
                {"Banana","Shop2","Shop3","Shop4"},
                {"Orange","Shop1","Shop3","Shop4"},
                {"Pear", "Shop2", "Shop4"}}));
        System.out.println(salesData(new String[][] {{"Fridge","Shop2","Shop3"},
                {"Microwave","Shop1","Shop2","Shop3","Shop4"},
                {"Laptop","Shop3","Shop4"},
                {"Phone", "Shop1","Shop2","Shop3","Shop4"}}));
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println(dataScience(new int[][] {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}}));
        System.out.println(dataScience(new int[][] {{6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}}));
    }
    public static String replaceVovels(String x){
        x = x.replaceAll("[AEIOUYaeiouy]","*");
        return x;
    }
    public static String stringTransform(String x){
        char[] c = x.toCharArray();
        int y = 0;
        int z = 1;
        for (int i = 0; i < c.length;i++){
            for(int j = i + 1; j < c.length; j++){
                if (c[i] == c[j]){
                    c[i] = 'D';
                }
            }
        }
        x = new String(c);
        return x;
    }
    public static boolean doesBlockkFit(int a, int b, int c, int w, int h){
        if ((a * b <= w * h) || (a * c <= w * h) || (b * c <= w * h)){
            return true;
        }
        return false;
    }
    public static boolean numCheck(int x){
        int sum = 0;
        int c = x;
        while (x > 0){
            sum = sum + (x % 10) * (x % 10);
            x = x / 10;
        }
        if ((c % 2 != 0) && (sum % 2 != 0)){
            return true;
        }else{
            return false;
        }
    }
    public static int countRoots(int[] x){
        int y = x[0];
        int c = x[1];
        int z = x[2];
        int sum = c * c - 4 * y * z;
        if(sum > 0){
            return 2;
        } else if (sum == 0) {
            return 1;
        }else {
            return 0;
        }
    }
    public static String salesData (String[][] x){
        int f = 2;
        int c = 0;
        while (c < 5){
            if(x[c].length == 5){
                f = f + c;
                if(x[f].length == 5){
                    return x[c][0] + " " +x[f][0];
                }else {
                    return x[c][0];
                }
            }
            c++;
        }
        System.out.println(c);
        return x[0][0];
    }
    public static boolean validSplit(String x){
        String[] words = x.split(" ");
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1;j < words.length;j++){
                if(words[i].charAt(words[i].length()-1) == words[j].charAt(0)){
                    String tmp = words[j];
                    words[j] = words[i + 1];
                    words[i + 1] = tmp;
                }
                if(words[i].charAt(0) == words[j].charAt(words[j].length()-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean waveForm(int[] x){
        for(int i = 0; i < x.length; i++){
            for(int j = 1; j < x.length; j++){
                for(int c = 2; c < x.length; c++){
                    if((x[i] > x[j]) && (x[j] < x[c])){
                        return true;
                    } else if ((x[i] < x[j]) && (x[j] > x[c])) {
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    public static String commonVovel(String x){
        int a = 0, e = 0, i = 0, o = 0, u = 0, y = 0;
        for (char element : x.toLowerCase().toCharArray()){
            if (element == 'a') a++;
            if (element == 'e') e++;
            if (element == 'i') i++;
            if (element == 'o') o++;
            if (element == 'u') u++;
            if (element == 'y') y++;
        }
        if((e > a) || (i > a) || (o > a) || (u > a) || (y > a)){
            if((e > y) || (i > y) || (o > y) || (u > y)){
                if((e > u) || (i > u) || (o > u)){
                    if((e > o) || (i > o)){
                        if(e > i){
                            return "e";
                        }else{
                            return "i";
                        }
                    }else {
                        return "o";
                    }
                }else {
                    return "u";
                }
            }else {
                return "y";
            }
        }else{
            return "a";
        }
    }
    public static String dataScience(int[][] x){
        int Str1=0,Str2=0,Str3=0,Str4=0,Str5=0;
        for (int i=0;i<x.length;i++){
            Str1+=x[0][i];
        }
        x[1][1] = Str1 / 5;
        for (int i=0;i<x.length;i++){
            Str2+=x[1][i];
        }
        x[2][2] = Str2 / 5;
        for (int i=0;i<x.length;i++){
            Str3+=x[2][i];
        }
        x[0][0] = Str3 / 5;
        for (int i=0;i<x.length;i++){
            Str4+=x[2][i];
        }
        x[3][3] = Str4 / 5;
        for (int i=0;i<x.length;i++){
            Str5+=x[2][i];
        }
        x[4][4] = Str5 / 5;
        return Arrays.deepToString(x);
    }
}

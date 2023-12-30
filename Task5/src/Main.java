import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB" , "CDCD"));
        System.out.println(sameLetterPattern("ABCBA" , "BCDCB"));
        System.out.println(sameLetterPattern("FFGG" , "CDCD"));
        System.out.println(sameLetterPattern("FFFF" , "ABCD"));
        System.out.println(spiderVsFly("H3","E2"));
        System.out.println(spiderVsFly("A4","B2"));
        System.out.println(spiderVsFly("A4","C2"));
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println(totalPoints(new String[] { "cat", "create", "sat" }, "caster"));
        System.out.println(totalPoints(new String[] { "trance", "recant" }, "recant"));
        System.out.println(totalPoints(new String[] { "dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "sted"));
        System.out.println(sumsUp(new int[] { 1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[] { 1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[] { 10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[] { 1, 6, 5, 4, 8, 2, 3, 7 }));
        System.out.println(takeDownAverage(new String[] { "95%", "83%", "90%", "87%", "88%", "93%" }));
        System.out.println(takeDownAverage(new String[] { "10%" }));
        System.out.println(takeDownAverage(new String[] { "53%", "79%"}));
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }
    //1
    public static boolean sameLetterPattern(String x,String y){
        if(x.length() != y.length()) {
            return false;
        }
        HashMap<Character, Integer> xmap = new HashMap<>();
        HashMap<Character, Integer> ymap = new HashMap<>();

        for(int i = 0; i < x.length(); i++) {
            if (xmap.get(x.charAt(i)) != ymap.get(y.charAt(i))) return false;
            xmap.put(x.charAt(i), i);
            ymap.put(y.charAt(i), i);
        }
        return true;
    }
    //2
    public static String spiderVsFly(String spider, String fly) {
        int spiderRing = spider.charAt(1) - '0';
        char spiderRadial = spider.charAt(0);

        int flyRing = fly.charAt(1) - '0';
        char flyRadial = fly.charAt(0);

        StringBuilder path = new StringBuilder();


        for (int i = spiderRing; i >= 1; i--) {
            path.append(spiderRadial).append(i).append("-");
        }

        for (int i = 1; i <= flyRing; i++) {
            path.append(flyRadial).append(i).append("-");
        }

        return path.substring(0, path.length() - 1);
    }
    //3
    static int digitsCount(long number) {
        if (number == 0) {
            return 1;
        } else {
            return countDigitsRecursive(number);
        }
    }

    static int countDigitsRecursive(long number) {
        if (number == 0) {
            return 0;
        } else {
            return 1 + countDigitsRecursive(number / 10);
        }
    }
    //4
    static int totalPoints(String[] words, String scrambledWord) {
        int totalPoints = 0;
        Map<Character, Integer> scrambledWordCount = countLetters(scrambledWord);

        for (String word : words) {
            Map<Character, Integer> wordCount = countLetters(word);

            if (isValidWord(scrambledWordCount, wordCount)) {

                int wordPoints = calculatePoints(word.length());
                totalPoints += wordPoints;
            }
        }

        return totalPoints;
    }

    static Map<Character, Integer> countLetters(String word) {
        Map<Character, Integer> letterCount = new HashMap<>();

        for (char letter : word.toCharArray()) {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }

        return letterCount;
    }

    static boolean isValidWord(Map<Character, Integer> scrambledWordCount, Map<Character, Integer> wordCount) {
        for (Map.Entry<Character, Integer> entry : wordCount.entrySet()) {
            char letter = entry.getKey();
            int count = entry.getValue();

            if (!scrambledWordCount.containsKey(letter) || scrambledWordCount.get(letter) < count) {
                return false;
            }
        }

        return true;
    }

    static int calculatePoints(int wordLength) {
        if (wordLength == 3) {
            return 1;
        } else if (wordLength == 4) {
            return 2;
        } else if (wordLength == 5) {
            return 3;
        } else if (wordLength == 6) {
            return 4 + 50;
        }

        return 0;
    }
    //5
    public static ArrayList<ArrayList<Integer>> sumsUp(int[] arr) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    int indexRes = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
        boolean b = true;
        for (Integer key : map.keySet()) {
            if (key + arr[i] == 8) {
                ArrayList<Integer> cl = new ArrayList<Integer>();
                cl.add(0, Math.min(key, arr[i]));
                cl.add(1, Math.max(key, arr[i]));
                res.add(indexRes, cl);
                indexRes++;
                map.remove(key, 1);
                b = false;
                break;
            }
        }
        if (b)
            map.put(arr[i], 1);
    }
    return res;

    }
    //6
    public static String takeDownAverage(String[] arr) {
        if (arr.length == 0)
            return "0%";
        double sum = 0;
        for (String str : arr) {
            int number = Integer.parseInt(str.split("%")[0]);
            sum += number;
        }
        double avg = sum / arr.length;
        double res = (arr.length + 1) * (avg - 5) - sum;
        return Integer.toString((int) Math.round(res)) + "%";
    }
    //7
    static String caesarCipher(String operation, String message, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';

                int newChar = (ch - base + (operation.equals("encode") ? shift : 26 - shift)) % 26;

                if (newChar < 0) {
                    newChar += 26;
                }

                result.append((char) (newChar + base));
            } else {
                result.append(ch);
            }
        }

        return result.toString().toUpperCase(Locale.ROOT);
    }
    //8
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int setSetup(int n, int k) {
        if (n < k) {
            return 0;
        }
        return factorial(n) / factorial(n - k);
    }
    //9
    static String timeDifference(String cityA, String timestampA, String cityB) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);

        LocalDateTime localDateTimeA = LocalDateTime.parse(timestampA, formatter);

        ZoneId zoneA = ZoneId.of(getTimeZone(cityA));
        ZoneId zoneB = ZoneId.of(getTimeZone(cityB));


        ZonedDateTime zonedDateTimeA = ZonedDateTime.of(localDateTimeA, zoneA);
        ZonedDateTime zonedDateTimeB = zonedDateTimeA.withZoneSameInstant(zoneB);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        return zonedDateTimeB.format(outputFormatter);
    }
    static String getTimeZone(String city) {
        switch (city) {
            case "Los Angeles":
                return "America/Los_Angeles";
            case "New York":
                return "America/New_York";
            case "Caracas":
                return "America/Caracas";
            case "Buenos Aires":
                return "America/Argentina/Buenos_Aires";
            case "London":
                return "Europe/London";
            case "Rome":
                return "Europe/Rome";
            case "Moscow":
                return "Europe/Moscow";
            case "Tehran":
                return "Asia/Tehran";
            case "New Delhi":
                return "Asia/Kolkata";
            case "Beijing":
                return "Asia/Shanghai";
            case "Canberra":
                return "Australia/Sydney";
            default:
                throw new IllegalArgumentException("Unknown city: " + city);
        }
    }
    //10
    public static boolean isNew(int num) {
        String str = String.valueOf(num);
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != '0' && str.charAt(i) < str.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GGww {
    @DataProcessor
    public String ggww(HashMap<String, Integer> data) {
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().filter((x) -> x.getValue() > 10).toList();
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            output.append(entry.getKey());
            output.append(" ");
            output.append(entry.getValue().toString());
            output.append("\n");
        }
        return output.toString();
    }
}

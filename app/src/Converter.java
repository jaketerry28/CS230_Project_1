import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Converter {
    public static void toHexa() {
        Partitioner partitioner = new Partitioner();
        HashMap<Integer, List<String>> instructions = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (instructions.containsValue("LDBA")) {
            list.add("D");
        } else if (instructions.containsValue("STBA")) {
            list.add("F");
        } else if (instructions.containsValue("STWA")) {
            list.add("E");
        } else if (instructions.containsValue("ANDA")) {
            list.add("8");
        } else if (instructions.containsValue("STWA")) {
            list.add("E1");
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Partitioner {

    public static void main(String[] args) {

        HashMap<Integer, List<String>> instructions = new HashMap<>();
        int lineNum = 0;

        try {
            File file = new File("documents/code/program1.pep"); // your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //Clean up
                line = line.trim();
                line = line.replace(",","");
                line = line.split(";")[0]; // remove comments

                // partition
                String[] parts = line.split(" ");
                instructions.put(lineNum, Arrays.asList(parts));
                lineNum++;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        // Example output
        // 0: [LDBA, 0x0048,, i]
        // 1: [STBA, 0xFC16,, d]
        for (Map.Entry<Integer, List<String>> entry : instructions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return instructions

    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Partitioner {

    // wrapper class to hold both instructions and branches
    public static class ParsedData {
        public HashMap<Integer, List<String>> instructions;
        public HashMap<Integer, List<String>> branches;

        public ParsedData(HashMap<Integer, List<String>> instructions,
                          HashMap<Integer, List<String>> branches) {
            this.instructions = instructions;
            this.branches = branches;
        }
    }

    // reads file and builds instructions + branches maps
    public static ParsedData parse(String filepath) {

        HashMap<Integer, List<String>> instructions = new HashMap<>();
        HashMap<Integer, List<String>> branches = new HashMap<>();
        int lineNum = 0;

        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // clean up
                line = line.trim();
                line = line.replace(",", "");
                line = line.split(";")[0];       // remove comments
                if (line.isBlank() || line.startsWith(";")) continue; // skip empty lines

                // find and store labels
                String firstWord = line.split("\\s+")[0];
                if (firstWord.endsWith(":")) {
                    System.out.println("Detected label: " + firstWord);
                    branches.put(lineNum, Arrays.asList(firstWord.replace(":", ""))); // store label

                    // Remove the label from the line for instructions
                    line = line.substring(firstWord.length()).trim();
                    if (line.isBlank()) {
                        lineNum++;
                        continue; // skip if nothing remains after label
                    }
                }

                // store instructions
                String[] parts = line.split("\\s+");
                instructions.put(lineNum, Arrays.asList(parts));

                lineNum++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return new ParsedData(instructions, branches);
    }
}

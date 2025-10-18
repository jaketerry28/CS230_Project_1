import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Partitioner {

    // wrapper class to hold both instructions and branches
    public static class ParsedData {
        public HashMap<Integer, List<String>> assembly_code;
        public HashMap<String, String> branches;

        public ParsedData(HashMap<Integer, List<String>> assembly_code,
                          HashMap<String, String> branches) {
            this.assembly_code = assembly_code;
            this.branches = branches;
        }
    }

    // reads file and builds assembly_code + branches maps
    public static ParsedData parse(String filepath) {

        HashMap<Integer, List<String>> assembly_code = new HashMap<>();
        HashMap<String, String> branches = new HashMap<>();
        int lineNum = 0;
        int bytesUsed = 0;

        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String hex = String.format("%04X", bytesUsed);
                String line = scanner.nextLine();

                // clean up
                line = line.trim();
                line = line.replace(",", "");
                line = line.split(";")[0];       // first split, remove comments
                if (line.isBlank() || line.startsWith(";")) continue; // skip empty lines


                // find and store labels
                String firstWord = line.split("\\s+")[0];

                if (firstWord.endsWith(":")) {

                    // Remove the label from the line for assembly_code
                    line = line.substring(firstWord.length()).trim();
                    if (line.isBlank()) {
                        lineNum++;
                        continue; // skip if nothing remains after label
                    }

                    firstWord = firstWord.replace(":", "");
                    branches.put(firstWord, hex);

                }

                // store assembly_code
                List<String> parts = new ArrayList<>(Arrays.asList(line.split("\\s+")));
                parts.add(hex);
                assembly_code.put(lineNum, parts);

                lineNum++;
                bytesUsed +=  parts.size() - 1;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return new ParsedData(assembly_code, branches);
    }
}

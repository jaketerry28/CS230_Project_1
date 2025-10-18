import java.util.*;


public class Main {

    public static void main(String[] args) {
        // args[0] should be the file path to parse
        if (args.length == 0) {
            System.out.println("Please provide a file path as the first argument.");
            return;
        }

        // Call the parser
        Partitioner.ParsedData data = Partitioner.parse(args[0]);

        // Call the converter
        Instructions converter = new Instructions();
        ArrayList list = converter.instructionConvert(data);

        // Log instructions
        System.out.println("\nBefore Instructions:");
        for (int i : data.assembly_code.keySet()) {
            System.out.println(i + ": " + data.assembly_code.get(i));
        } // end for

        System.out.println("\n======================================");
        System.out.println("\nAfter Instructions");

        for (Object i : list) {
            if (i != null) {
                System.out.print(i.toString() + " ");
            }
        } // end for
    }
}




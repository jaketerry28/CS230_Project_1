
public class Main {

    public static void main(String[] args) {
        // args[0] should be the file path to parse
        if (args.length == 0) {
            System.out.println("Please provide a file path as the first argument.");
            return;
        }

        // Call the parser
        Partitioner.ParsedData data = Partitioner.parse(args[0]);

        // Log instructions
        System.out.println("\nInstructions:");
        for (int i : data.instructions.keySet()) {
            System.out.println(i + ": " + data.instructions.get(i));
        } // end for

//         Log branches
        System.out.println("\nBranches:");
        for (String i : data.branches.keySet()) {
            System.out.println(i + ":" + data.branches.get(i));
        } // end for

//        Example on how to get individual line instructions
//        System.out.println(data.instructions.get(1).get(0));
//
//        for (int i : data.instructions.keySet()) {
//            if (data.instructions.get(i).get(0).contains("BR")) {
//                String labelAddress = data.instructions.get(i).get(1);
//                System.out.println(data.branches.get(labelAddress));
//            }
//        } // end for
    }
}



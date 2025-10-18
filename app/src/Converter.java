import java.util.*;

public class Converter {
    ArrayList instruction_list = new ArrayList();
    Instructions instructions = new Instructions();

    public ArrayList instructionConvert(Partitioner.ParsedData data) {

        //looks to see what instruction set is present and gets the corresponding value
        for (int i : data.instructions.keySet()) {
            if (data.instructions.get(i).get(0).contains("LDBA")) {
                convertValues.add(instructions.getLDBA());
            }
            else if (data.instructions.get(i).get(0).contains("LDWA")) {
                convertValues.add(instructions.getLDWA());
            }
            else if (data.instructions.get(i).get(0).contains("STBA")) {
                convertValues.add(instructions.getSTBA());
            }
            else if (data.instructions.get(i).get(0).contains("STWA")) {
                convertValues.add(instructions.getSTWA());
            }
            else if (data.instructions.get(i).get(0).contains("ADDA")) {
                convertValues.add(instructions.getADDA());
            }
            else if (data.instructions.get(i).get(0).contains("ASLA")) {
                convertValues.add(instructions.getASLA());
            }
            else if (data.instructions.get(i).get(0).contains("ASRA")) {
                convertValues.add(instructions.getASRA());
            }
            else if (data.instructions.get(i).get(0).contains("STOP")) {
                convertValues.add(instructions.getSTOP());
            }
            else if (data.instructions.get(i).get(0).contains("CPBA")) {
                convertValues.add(instructions.getCPBA());
            }
            else if (data.instructions.get(i).get(0).contains("BRNE")) {
                convertValues.add(instructions.getBRNE());
            }
        }
        return convertValues;
    // }
    // public HashMap<String, String> hexaConvert(String[] args) {
    //     Partitioner.ParsedData data = Partitioner.parse(args[0]);

    //     return convertValues;
    // }
    // public HashMap<String, String> addressingTypeConvert(String[] args) {
    //     Partitioner.ParsedData data = Partitioner.parse(args[0]);

    //     for (int i : data.instructions.keySet()) {
    //         if (data.instructions.get(i).get(3).contains("i")) {
    //             convertValues.put("Output2", "0");
    //         }
    //         else if (data.instructions.get(i).get(3).contains("d")) {
    //             convertValues.put("Output2", "1");
    //         }
    //     }
    //     return convertValues;
    }
}


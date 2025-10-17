import java.util.HashMap;

public class Converter {
    HashMap<String, String> convertValues = new HashMap<>();
    Instructions instructions = new Instructions();

    public HashMap<String, String> instructionConvert(String[] args) {
        Partitioner.ParsedData data = Partitioner.parse(args[0]);

        //looks to see what instruction set is present and gets the corresponding value
        for (int i : data.instructions.keySet()) {
            if (data.instructions.get(i).get(1).contains("LDBA")) {
                convertValues.put("Output1", instructions.getLDBA());
            }
            else if (data.instructions.get(i).get(1).contains("LDWA")) {
                convertValues.put("Output1", instructions.getLDWA());
            }
            else if (data.instructions.get(i).get(1).contains("STBA")) {
                convertValues.put("Output1", instructions.getSTBA());
            }
            else if (data.instructions.get(i).get(1).contains("STWA")) {
                convertValues.put("Output1", instructions.getSTWA());
            }
            else if (data.instructions.get(i).get(1).contains("ADDA")) {
                convertValues.put("Output1", instructions.getADDA());
            }
            else if (data.instructions.get(i).get(1).contains("ASLA")) {
                convertValues.put("Output1", instructions.getASLA());
            }
            else if (data.instructions.get(i).get(1).contains("ASRA")) {
                convertValues.put("Output1", instructions.getASRA());
            }
            else if (data.instructions.get(i).get(1).contains("STOP")) {
                convertValues.put("Output1", instructions.getSTOP());
            }
            else if (data.instructions.get(i).get(1).contains("CPBA")) {
                convertValues.put("Output1", instructions.getCPBA());
            }
            else if (data.instructions.get(i).get(1).contains("BRNE")) {
                convertValues.put("Output1", instructions.getBRNE());
            }
        }
        return convertValues;
    }
    public HashMap<String, String> hexaConvert(String[] args) {
        Partitioner.ParsedData data = Partitioner.parse(args[0]);

        return convertValues;
    }
    public HashMap<String, String> addressingTypeConvert(String[] args) {
        Partitioner.ParsedData data = Partitioner.parse(args[0]);

        for (int i : data.instructions.keySet()) {
            if (data.instructions.get(i).get(3).contains("i")) {
                convertValues.put("Output2", "0");
            }
            else if (data.instructions.get(i).get(3).contains("d")) {
                convertValues.put("Output2", "1");
            }
        }
        return convertValues;
    }
}

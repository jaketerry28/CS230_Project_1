import java.util.*;

public class Instructions {

    ArrayList<String> convertValues = new ArrayList();
    String addressingMode;
    String instructionMode;
    String bitInstructions;
    String value;

    public ArrayList<String> instructionConvert(Partitioner.ParsedData data) {
        //looks to see what instruction set is present and gets the corresponding value
        for (int i : data.assembly_code.keySet()) {

            // get addressing type
            if (data.assembly_code.get(i).size() > 2){
                addressingMode = getAddressingMode(data.assembly_code.get(i).get(2));
            }
            else{
                addressingMode = "";
            }

            if (data.assembly_code.get(i).get(0).contains("LDBA")) {
                instructionMode = this.getLDBA();
            }
            else if (data.assembly_code.get(i).get(0).contains("LDWA")) {
                instructionMode = this.getLDWA();
            }
            else if (data.assembly_code.get(i).get(0).contains("STBA")) {
                instructionMode = this.getSTBA();
            }
            else if (data.assembly_code.get(i).get(0).contains("STWA")) {
                instructionMode = this.getSTWA();
            }
            else if (data.assembly_code.get(i).get(0).contains("ADDA")) {
                instructionMode = this.getADDA();
            }
            else if (data.assembly_code.get(i).get(0).contains("ASLA")) {
                instructionMode = this.getASLA();
            }
            else if (data.assembly_code.get(i).get(0).contains("ASRA")) {
                instructionMode = this.getASRA();
            }
            else if (data.assembly_code.get(i).get(0).contains("STOP")) {
                instructionMode = this.getSTOP();
            }

            else if (data.assembly_code.get(i).get(0).contains(".END")) {
                instructionMode = this.getEND();
            }

            else if (data.assembly_code.get(i).get(0).contains("CPBA")) {
                instructionMode = this.getCPBA();
            }
            else if (data.assembly_code.get(i).get(0).contains("BRNE")) {
                instructionMode = this.getBRNE();
                addressingMode = "";
            }

            // strips 0x or gets the bit position of a label
            value = data.assembly_code.get(i).get(1);
            value = getValue(data, value);

            bitInstructions = instructionMode + addressingMode;
            convertValues.add(bitInstructions);
            convertValues.add(value);

        }
        return convertValues;
    }

    //used to call upon to make conversion easier
    public String getLDBA() {
        String LDBA;
        LDBA = "D";
        return LDBA;
    }
    public String getLDWA() {
        String LDWA;
        LDWA = "C";
        return LDWA;
    }
    public String getSTBA() {
        String STBA;
        STBA = "F";
        return STBA;
    }
    public String getSTWA() {
        String STWA;
        STWA = "E";
        return STWA;
    }
    public String getADDA() {
        String ADDA;
        ADDA = "6";
        return ADDA;
    }
    public String getASLA() {
        String ASLA;
        ASLA = "0A";
        return ASLA;
    }
    public String getASRA() {
        String ASRA;
        ASRA = "0C";
        return ASRA;
    }
    public String getSTOP() {
        String STOP;
        STOP = "00";
        return STOP;
    }
    public String getCPBA() {
        String CPBA;
        CPBA = "B";
        return CPBA;
    }
    public String getBRNE() {
        String BRNE;
        BRNE = "1A";
        return BRNE;
    }
    public String getEND() {
        String END;
        END = "zz";
        return END;
    }
    public String getAddressingMode(String mode) {
        String addressingMode;
        if (mode.equals("i")){
            addressingMode = "0";
            return addressingMode;
        }
        else {
            addressingMode = "1";
            return addressingMode;
        }
    }

    public String getValue(Partitioner.ParsedData data, String value){
        if (value.contains("0x")){
            value = value.split("0x")[1];
            if (value.length() < 4){
                value = "00" + value;
            }
        }
        else if  (!value.isEmpty()){
            value = data.branches.get(value);
        }
        return value;
    }
}



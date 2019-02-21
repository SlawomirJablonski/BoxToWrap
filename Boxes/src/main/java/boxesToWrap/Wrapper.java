package boxesToWrap;

import java.io.IOException;
import java.util.List;

public class Wrapper {
    public static void main(String[] args) throws IOException {
        String nazwaPliku = "https://raw.githubusercontent.com/SamouczekProgramisty/StrefaZadaniowaSamouka/master/test_input.txt";
        BoxesToWrap boxes = new BoxesToWrap();
        boxes.readFile(nazwaPliku);
        List<String> boxesToWrap = boxes.getDimentionsInString();
        int answer = boxes.countPaperField(boxesToWrap);
        System.out.println("Potrzeba " +answer+" decymentrów kwadratowych papieru do opakowania wszystkich paczek.");
    }
}
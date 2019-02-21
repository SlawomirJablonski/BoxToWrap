package boxesToWrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BoxesToWrap {
    private List<String> dimentionsInString = new ArrayList<>();

    public List<String> getDimentionsInString() {
        return dimentionsInString;
    }

    public void readFile(String filePath) throws IOException {

        URL url = new URL(filePath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        try {
            String textLine = bufferedReader.readLine();
            do {
                dimentionsInString.add(textLine);
                textLine = bufferedReader.readLine();

            } while (textLine != null);
        } finally {
            bufferedReader.close();
        }
    }

    public int countPaperField(List<String> list){
        int allPaper = 0;
        for (String element:list) {
            StringTokenizer stringTokenizer = new StringTokenizer(element, "x");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            int f1 = a*b;
            int f2 = b*c;
            int f3 = a*c;

            int[] array = new int[3];
            array[0]=f1;
            array[1]=f2;
            array[2]=f3;

            int extrafield = array[0];
            for (int i=1; i<3; i++) {
                if (extrafield > array[i]) {
                    extrafield = array[i];
                }
            }
            int paperForElement = 2*f1+2*f2+2*f3+extrafield;
            allPaper += paperForElement;
        }
        return allPaper;
    }
}
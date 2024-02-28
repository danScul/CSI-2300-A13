import java.io.*;

public class CountWords {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            int numLines = 0;
            while (reader.readLine() != null) {
                numLines++;
            }

            reader = new BufferedReader(new FileReader("input.txt")); // Reset the BufferedReader

            String arrStr[] = new String[numLines];
            int arrQuant[] = new int[numLines];
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                int found = -1;
                for (int i = 0; i < numLines; i++) {
                    if (arrStr[i] != null && arrStr[i].equals(line)) {
                        arrQuant[i]++;
                        found = 1;
                        break;
                    }
                }
                if (found == -1) {
                    arrStr[count] = line;
                    arrQuant[count]++;
                    count++;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (int j = 0; j < arrStr.length; j++) {
                if (arrStr[j] == null)
                    break;
                writer.write(arrStr[j] + ": " + arrQuant[j]);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

package FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFromFile {
    BufferedReader writer;

    public ReadingFromFile(){
        try {
            writer = new BufferedReader (new FileReader("Toffee-E-commerce-Application/userData.txt"));
            String line;
            while((line = writer.readLine()) != null)
                System.out.println(line);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

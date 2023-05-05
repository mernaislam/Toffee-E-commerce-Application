package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class WritingToFile {
    BufferedWriter writer;

    public WritingToFile(String s){
        try {
            writer = new BufferedWriter (new FileWriter("Toffee-E-commerce-Application/userData.txt", true));
            writer.write(s + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

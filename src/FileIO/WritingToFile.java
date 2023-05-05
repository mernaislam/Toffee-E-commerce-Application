package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class WritingToFile {
    BufferedWriter writer;

    public WritingToFile(String fileName, String line){
        try {
            writer = new BufferedWriter (new FileWriter("Toffee-E-commerce-Application/" + fileName + ".txt", true));
            writer.write(line + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

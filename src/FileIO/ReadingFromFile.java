package FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFromFile {
    BufferedReader writer;

    public void display(String fileName){
        try {
            writer = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = writer.readLine()) != null){
                System.out.println(line);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isEmailExist(String fileName, String toSearch){
        try {
            writer = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = writer.readLine()) != null){
                if(line.equals(toSearch)){
                   return true;
                }
                line = writer.readLine();
            }
            writer.close();
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

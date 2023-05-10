package FileIO;

import java.io.*;

public class ReadingFromFile {
    BufferedReader reader;

    public void display(String fileName){
        try {
            reader = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isEmailExist(String fileName, String toSearch){
        try {
            reader = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals(toSearch)){
                   return true;
                }
                line = reader.readLine();
            }
            reader.close();
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int getLineNumber(String fileName, String categoryName){
        int cnt = 0;
        boolean found = false;
        try {
            reader = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = reader.readLine()) != null){
                cnt++;
                if(line.equals(categoryName)){
                    found = true;
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!found){
            cnt = 0;
        }
        return cnt;
    }

}
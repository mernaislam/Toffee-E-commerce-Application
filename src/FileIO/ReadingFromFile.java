package FileIO;

import java.io.*;
import java.util.ArrayList;

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
    public int getLineNumber(String fileName, String categoryName){
        int cnt = 0;
        boolean found = false;
        try {
            writer = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = writer.readLine()) != null){
                cnt++;
                if(line.equals(categoryName)){
                    found = true;
                    break;
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!found){
            cnt = 0;
        }
        return cnt;
    }
    public void clearFile(String fileName)
    {
        try{
            FileWriter fw = new FileWriter("Toffee-E-commerce-Application/" + fileName + ".txt", false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        }
        catch(Exception exception)
        {
            System.out.println("Exception have been caught");
        }

    }

    public void addUpdatedFileContent(String fileName,String lineContent, String categoryName) throws IOException {
        int newLine = getLineNumber(fileName, categoryName);
        ArrayList<String> content = new ArrayList<>();
        try {
            writer = new BufferedReader(new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while ((line = writer.readLine()) != null)
            {
                content.add(line);
            }
            writer.close();
        }
            catch(IOException e)
            {
            throw new RuntimeException(e);
        }
        if(newLine == 0){
            content.add(lineContent);
        }
        else {
            content.add(newLine, lineContent);
        }
        clearFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter("Toffee-E-commerce-Application/" + fileName + ".txt", true));
        for (String Line : content) {
            writer.write(Line + "\n");
        }
        writer.close();
    }
}
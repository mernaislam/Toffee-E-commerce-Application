package DataManager;

import java.io.*;
import java.util.ArrayList;

public class WritingToFile
{
    BufferedWriter writer;
    BufferedReader reader;

    public WritingToFile(){}

    public WritingToFile(String fileName, String line)
    {
        try
        {
            writer = new BufferedWriter (new FileWriter("Toffee-E-commerce-Application/" + fileName + ".txt", true));
            writer.write(line + "\n");
            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void clearFile(String fileName)
    {
        try
        {
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

    public void addUpdatedFileContent(String fileName,String lineContent, String categoryName) throws IOException
    {
        ReadingFromFile read = new ReadingFromFile();
        int newLine = read.getLineNumber(fileName, categoryName);
        ArrayList<String> content = new ArrayList<>();
        try
        {
            reader = new BufferedReader(new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                content.add(line);
            }
            reader.close();
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
        if(newLine == 0)
        {
            content.add(lineContent);
        }
        else
        {
            content.add(newLine, lineContent);
        }
        clearFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter("Toffee-E-commerce-Application/" + fileName + ".txt", true));
        for (String Line : content)
        {
            writer.write(Line + "\n");
        }
        writer.close();
    }

    public void updateItemQuantity(String fileName, String toAdd, int search) throws IOException
    {
        String value = Integer.toString(search);
        ArrayList<String> content = new ArrayList<>();
        BufferedReader read;
        try
        {
            read = new BufferedReader(new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            String id;
            while ((line = read.readLine()) != null)
            {
                String[] words = line.split("\t\t");
                id = words[0];
                if(id.equals(value))
                {
                    content.add(toAdd);
                }
                else
                {
                    content.add(line);
                }
            }
            read.close();
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
        clearFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter("Toffee-E-commerce-Application/" + fileName + ".txt", true));
        for (String Line : content)
        {
            writer.write(Line + "\n");
        }
        writer.close();
    }
}

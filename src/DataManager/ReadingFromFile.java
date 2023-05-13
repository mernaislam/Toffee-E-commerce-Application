package DataManager;

import java.io.*;

/**
 * This is a class that manages accessing and reading the data of the system.
 */
public class ReadingFromFile
{
    /**
     * BufferedReader used for reading from a file.
     */
    BufferedReader reader;

    /**
     * Displays the content of a file
     * @param fileName the name of the text file
     */

    public void display(String fileName)
    {
        try
        {
            reader = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * Checks if a word exists in a text file
     * @param fileName the name of the text file
     * @param toSearch the word to search for
     * @return true if the word is found, otherwise returns false
     */
    public boolean isEmailExist(String fileName, String toSearch)
    {
        try
        {
            reader = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = reader.readLine()) != null)
            {
                if(line.equals(toSearch))
                {
                   return true;
                }
                line = reader.readLine();
            }
            reader.close();
            return false;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * Finds the position of the desired line in the file
     * @param fileName the name of the text file
     * @param categoryName the line content to get its number in the text file
     * @return line number of the desired line in the file
     * */
    public int getLineNumber(String fileName, String categoryName)
    {
        int cnt = 0;
        boolean found = false;
        try
        {
            reader = new BufferedReader (new FileReader("Toffee-E-commerce-Application/" + fileName + ".txt"));
            String line;
            while((line = reader.readLine()) != null)
            {
                cnt++;
                if(line.equals(categoryName))
                {
                    found = true;
                    break;
                }
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        if(!found)
        {
            cnt = 0;
        }
        return cnt;
    }
}
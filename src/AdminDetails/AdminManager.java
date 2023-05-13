package AdminDetails;

import CustomerDetails.Account;
import CustomerDetails.CustomerManager;
import DataManager.ReadingFromFile;
import DataManager.WritingToFile;
import ItemCollection.Catalog;
import ItemCollection.Category;
import ItemCollection.CollectionManager;
import ItemCollection.Items;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static ItemCollection.UnitType.Loose;
import static ItemCollection.UnitType.Sealed;

/**
 * This is a class that manages functions done by the administrator.
 */
public class AdminManager
{
    /**
     * The administrator the class manages
     */
    Administrator admin = new Administrator();
    /**
     * Logs the administrator in the system
     *@return true if the admin is logged in, false otherwise
     */
    public boolean login() throws IOException
    {
        Scanner s = new Scanner((System.in));
        System.out.println("Please enter your credentials.");
        System.out.print("Username: ");
        String username = s.nextLine();
        System.out.print("Password: ");
        String password = s.nextLine();
        return login(username, password);
    }
    /**
     * Logs the administrator in the system
     * @param username the username of the administrator
     * @param password the password of the administrator
     *@return true if the admin is logged in, false otherwise
     */

    public boolean login(String username, String password) throws IOException
    {
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader("Toffee-E-commerce-Application/AdminDetails.txt"));
            String line;
            boolean found = false;
            while((line = reader.readLine()) != null)
            {
                if(line.equals(username))
                {
                    found = true;
                    line = reader.readLine();
                    if(line.equals(password))
                    {
                        System.out.println("Successfully logged in");
                        displayMainMenu();
                        return true;
                    }
                    else
                    {
                        int cnt = 3;
                        while(cnt != 0)
                        {
                            System.out.print("In correct Password, please try again: ");
                            Scanner s = new Scanner(System.in);
                            password = s.nextLine();
                            if(line.equals(password))
                            {
                                System.out.println("Successfully logged in\n");
                                return true;
                            }
                            cnt--;
                        }
                        if(cnt == 0)
                        {
                            System.out.println("Can't open the app: ");
                            return false;
                        }
                    }
                }
            }
            if(!found)
            {
                System.out.println("Username not found please try again: ");
                login();
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }
    /**
     * Registers a new administrator in the system
     */
    public void register() throws IOException
    {
        CustomerManager customerManager = new CustomerManager();
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the username: ");
        String username  = sc.nextLine();
        ReadingFromFile read = new ReadingFromFile();
        while(read.isEmailExist("AdminDetails", username) || !CustomerManager.isValid(username, "^[a-zA-Z][a-zA-Z0-9_]{6,19}$"))
        {
            if(read.isEmailExist("AdminDetails", username))
            {
                System.out.print("Username already exists, please enter another username: ");
                username = sc.nextLine();
            }
            else if(!CustomerManager.isValid(username, "^[a-zA-Z][a-zA-Z0-9][_?]{6,19}$"))
            {
                System.out.print("Invalid format for username (ex: alex_tom): ");
                username = sc.nextLine();
            }
            else
            {
                break;
            }
        }
        //entering the password
        System.out.print("Please enter the password: ");
        password = sc.nextLine();
        // regex strong password
        while(!CustomerManager.isValid(password, "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20}$"))
        {
            System.out.print("Please enter a strong password: ");
            password = sc.nextLine();
        }
        System.out.print("Please re-enter the password: ");
        String pass2 = sc.nextLine();

        // validate password in re-entering
        while(!password.equals(pass2))
        {
            System.out.println("Passwords does not match, please re-enter the passwords:");
            System.out.print("Please re-enter the password: ");
            pass2 = sc.nextLine();
        }
        //Writing to file
        WritingToFile writeUsername = new WritingToFile("AdminDetails", username);
        WritingToFile writePassword = new WritingToFile("AdminDetails", pass2);
        System.out.println("This admin is successfully added to the system.\n");
        Account acc = new Account(username, password);
        admin.setAccount(acc);
        displayMainMenu();
    }
    /**
     * Displays the main menu of the administrator app
     */
    public void displayMainMenu() throws IOException
    {
        CollectionManager collectionManager = new CollectionManager();
        Scanner s = new Scanner(System.in);
        System.out.println("1. Add New Admin to The System. \n2. Add Item. \n3. Exit");
        System.out.println("Please enter your choice: ");
        int choice = s.nextInt();
        switch (choice)
        {
            case 1 ->
            {
                register();
                displayMainMenu();
                return;
            }
            case 2 ->
            {
                {
                    String name;
                    double price;
                    int quantity;
                    String category;
                    String brand;
                    Scanner input = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    System.out.print("Enter the item name: ");
                    name = input.nextLine();
                    System.out.print("Enter the item price: ");
                    price = input.nextDouble();
                    System.out.print("Enter the item quantity: ");
                    quantity = input.nextInt();
                    System.out.print("Enter the item's category: ");
                    category = input2.nextLine();
                    System.out.print("Enter the item's brand: ");
                    brand = input2.nextLine();
                    Items item = new Items(name, price, quantity, category, brand);
                    System.out.println("Enter the item's unit type:");
                    System.out.println("1. Loose");
                    System.out.println("2. Sealed");
                    choice = s.nextInt();
                    switch (choice)
                    {
                        case 1: {
                            item.setUnitType(Loose);
                            return;
                        }
                        case 2:
                        {
                            item.setUnitType(Sealed);
                            return;
                        }
                    }
                    collectionManager.writeItemToFile(item);
                    ArrayList<Category> categories;
                    collectionManager.addItemCatalog(item);
                    categories = collectionManager.getCatalog().getCategories();
                    String ItemData = item.getId() + "\t\t" + name + "\t\t" + price + "\t\t" + quantity;
                    ReadingFromFile read = new ReadingFromFile();
                    WritingToFile writer = new WritingToFile();
                    if (!read.isEmailExist("CategoriesList", category + ":"))
                    {
                        // add the category to the catalog
                        // add the item to the category
                        WritingToFile write = new WritingToFile("CategoriesList", category + ":");
                        WritingToFile writeItem = new WritingToFile("CategoriesList", ItemData);
                    }
                    else
                    {
                        //loop on the categories in the catalog to get the category you want and add the item in it
                        for (int i = 0; i < categories.size(); i++)
                        {
                            if (categories.get(i).getName().equals(category))
                            {
                                collectionManager.addItemCategory(item, categories.get(i));
                                break;
                            }
                        }
                    }
                    writer.addUpdatedFileContent("CategoriesList", ItemData, category + ":");
                }
                displayMainMenu();
            }
            case 3 ->
            {
                System.out.println("Thank you for using Toffee!");
            }
            default ->
            {
                System.out.println("Invalid Choice try again:");
                displayMainMenu();
            }
        }
    }
    /**
     * Runs the administrator app
     */
    public void runAdminApp() throws IOException
    {
        System.out.println("Toffee Application");
        if(login())
        {
            displayMainMenu();
        }
    }
}

package System;

import CustomerDetails.Account;
import CustomerDetails.Customer;
import FileIO.ReadingFromFile;
import FileIO.WritingToFile;
import ItemCollection.Catalog;
import ItemCollection.Category;
import Items.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static CustomerDetails.Customer.isValid;
import static Items.UnitType.Loose;
import static Items.UnitType.Sealed;


public class Administrator {
    private Account account;
    public void setAccount(Account account){
        this.account = account;
    }
    public boolean login() {
        Scanner s = new Scanner((System.in));
        System.out.println("Please enter your credentials.");
        System.out.print("Username: ");
        String username = s.nextLine();
        System.out.print("Password: ");
        String password = s.nextLine();
        return login(username, password);
    }

    public boolean login(String username, String password){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("Toffee-E-commerce-Application/AdminDetails.txt"));
            String line;
            boolean found = false;
            while((line = reader.readLine()) != null){
                if(line.equals(username))
                {
                    found = true;
                    line = reader.readLine();
                    if(line.equals(password))
                    {
                        System.out.println("Successfully logged in");
                        return true;
                    }
                    else
                    {
                        int cnt = 3;
                        while(cnt != 0){
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
                    }
                }
            }
            if(!found){
                System.out.println("Username not found please try again: ");
                login();
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Account acc = new Account(username,null,password,null);
        this.setAccount(acc);
        return true;
    }
    public void register() throws IOException {
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the username: ");
        String username  = sc.nextLine();
        ReadingFromFile read = new ReadingFromFile();
        while(read.isEmailExist("AdminDetails", username) || !isValid(username, "^[a-zA-Z][a-zA-Z0-9_]{6,19}$")){
            if(read.isEmailExist("AdminDetails", username)) {
                System.out.print("Username already exists, please enter another username: ");
                username = sc.nextLine();
            } else if(!isValid(username, "^[a-zA-Z][a-zA-Z0-9][_?]{6,19}$")) {
                System.out.print("Invalid format for username (ex: alex_tom): ");
                username = sc.nextLine();
            } else {
                break;
            }
        }
        //entering the password
        System.out.print("Please enter the password: ");
        password = sc.nextLine();
        // regex strong password
        while(!isValid(password, "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20}$")){
            System.out.print("Please enter a strong password: ");
            password = sc.nextLine();
        }
        System.out.print("Please re-enter the password: ");
        String pass2 = sc.nextLine();

        // validate password in re-entering
        while(!password.equals(pass2)){
            System.out.println("Passwords does not match, please re-enter the passwords:");
            System.out.print("Please re-enter the password: ");
            pass2 = sc.nextLine();
        }
        //Writing to file
        WritingToFile writeUsername = new WritingToFile("AdminDetails", username);
        WritingToFile writePassword = new WritingToFile("AdminDetails", pass2);
        System.out.println("This admin is successfully added to the system.\n");
        displayMainMenu();
        }

    public void displayMainMenu() throws IOException {
        Catalog catalog = new Catalog();
        Scanner s = new Scanner(System.in);
        System.out.println("1. Add New Admin to The System. \n2. Add Item. \n3. Exit");
        System.out.println("Please enter your choice: ");
        int choice = s.nextInt();
        switch(choice){
            case 1:
            {
                register();
                displayMainMenu();
            }
            case 2: {
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
                switch (choice) {
                    case 1:
                    {
                        item.setUnitType(Loose);
                    }
                    case 2:
                    {
                        item.setUnitType(Sealed);
                    }
                }
                item.writeItemToFile();
                ArrayList<Category> categories;
                catalog.addItem(item);
                categories = catalog.getCategories();
                String ItemData = item.getId() + "\t\t" + name + "\t\t" + price + "\t\t" + quantity;
                ReadingFromFile read = new ReadingFromFile();
                WritingToFile writer = new WritingToFile();
                if(!read.isEmailExist("CategoriesList", category+":"))
                {
                    // add the category to the catalog
                    // add the item to the category
                    WritingToFile write = new WritingToFile("CategoriesList", category +":");
                    WritingToFile writeItem = new WritingToFile("CategoriesList", ItemData);
                }
                else
                {
                    //loop on the categories in the catalog to get the category you want and add the item in it
                    for(int i = 0; i < categories.size(); i++)
                    {
                        if(categories.get(i).getName().equals(category))
                        {
                            categories.get(i).addItem(item);
                            break;
                        }
                    }
                    }
                    writer.addUpdatedFileContent("CategoriesList",ItemData, category+":");
                }
                displayMainMenu();
            case 3:
            {
                System.out.println("Thank you for using Toffee!");
                return;
            }
            default:
            {
                System.out.println("Invalid Choice try again:");
                displayMainMenu();
            }
        }
    }
}

package CustomerDetails;
import ItemCollection.Catalog;
import ItemCollection.Category;
import  OrderDetails.Order;
import Items.Items;
import ShoppingCart.Cart;
import FileIO.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private Account account;
    private int id;
    private Cart cart;
    private ArrayList<Order> orders = new ArrayList<Order>();

    public boolean login(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your credentials.");
        System.out.print("Username: ");
        String username = s.nextLine();
        System.out.print("Password: ");
        String password = s.nextLine();
        return login(username, password);
    }

    public boolean login(String username, String password){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("Toffee-E-commerce-Application/CustomerDetails.txt"));
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals(username)){
                    line = reader.readLine();
                    if(line.equals(password)){
                        System.out.println("Successfully Logged in");
                    } else {
                        int cnt = 3;
                        while(cnt != 0){
                            System.out.print("Incorrect Password, please try again: ");
                            Scanner s = new Scanner(System.in);
                            password = s.nextLine();
                            if(line.equals(password)){
                                System.out.println("Successfully Logged in");
                                return true;
                            }
                            cnt--;
                        }
                        if(cnt == 0){
                            System.out.println("Failed to log in");
                            return false;
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void register(){
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a username: ");
        String username = s.nextLine();

        // verify username does not exists to prevent duplicates
        ReadingFromFile read = new ReadingFromFile();
        while(read.isEmailExist("CustomerDetails", username) || isValid(username, "^[a-zA-Z][a-zA-Z0-9_]{6,19}$")){
            if(read.isEmailExist("CustomerDetails", username)) {
                System.out.print("Username already exists, please enter another username: ");
                username = s.nextLine();
            } else if(isValid(username, "^[a-zA-Z][a-zA-Z0-9][_?]{6,19}$")) {
                System.out.print("Invalid format for username (ex: alex_tom): ");
                username = s.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Please enter an email: ");
        String email = s.nextLine();

        // validate email
        while(!isValid(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            System.out.print("Please enter a valid email: ");
            email = s.nextLine();
        }

        System.out.print("Please enter a password: ");
        String pass1 = s.nextLine();

        // regex strong password
        while(!isValid(pass1, "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20}$")){
            System.out.print("Please enter a strong password: ");
            pass1 = s.nextLine();
        }
        System.out.print("Please re-enter the password: ");
        String pass2 = s.nextLine();

        // validate password in re-entering
        while(!pass1.equals(pass2)){
            System.out.println("Passwords does not match, please re-enter the passwords:");
            System.out.print("Please re-enter the password: ");
            pass2 = s.nextLine();
        }

        // Address Filling
        System.out.println("Great, now we need to fill your address!");
        System.out.print("Governorate: ");
        String gov = s.nextLine();
        System.out.print("Street: ");
        String street = s.nextLine();
        System.out.print("District: ");
        String district = s.nextLine();
        System.out.print("Building Number: ");
        int buildingNo = s.nextInt();
        System.out.print("Floor Number: ");
        int floorNo = s.nextInt();
        System.out.print("Flat Number: ");
        int flatNo = s.nextInt();

        Address add = new Address(gov, street, district, buildingNo, floorNo, flatNo);
        Account acc = new Account(username, email, pass1, add);
        account = acc;

        // Writing data to file
        WritingToFile writeUsername = new WritingToFile("CustomerDetails", username);
        WritingToFile writePassword = new WritingToFile("CustomerDetails", pass1);
        login(username, pass1);
    }

    public void displayMainMenu(){
        Catalog catalog = new Catalog();

        Category cat = new Category();
        BufferedReader read;
        String strId = null;
        String strPrice = null;
        String strQuantity = null;
        int intId = 1;
        double doublePrice = 1.0;
        int intQuantity = 1;
        String line;
        try {
            read = new BufferedReader(new FileReader("Toffee-E-commerce-Application/ItemFullData.txt"));
            while((line = read.readLine()) != null){
                String[] words = line.split("\t\t");
                strId = words[0];
                String name = words[1];
                strPrice = words[2];
                strQuantity = words[3];
                String category = words[4];
                String brand = words[5];
                intId = Integer.parseInt(strId);
                doublePrice = Double.parseDouble(strPrice);
                intQuantity = Integer.parseInt(strQuantity);
                Items item = new Items(name, doublePrice, intQuantity, category, brand);
                item.setId(intId);
                catalog.addItem(item);
//                if(cat.addCategory(category)){
//                    Category newCat = new Category();
//                    newCat.addItem(item, cat);
//                    catalog.addCategory(newCat);
//                } else {
//                    cat.addItem(item, cat);
//                }
            }
            read.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner s = new Scanner(System.in);
        System.out.println("1. View Catalog (All Items). \n2. View Catalog by Categories. \n3. checkout. \n4. Exit");
        System.out.println("Please enter your choice: ");
        int choice = s.nextInt();
        switch(choice){
            case 1: {
                catalog.displayAllItems(catalog);
                chooseItem();
            }
            case 2: {
                catalog.displayByCategory(catalog);
                chooseItemCategory();
            }
            case 3: {
                System.out.println("Nothing in cart for checkout! ");
                System.out.println("Returning to main menu... ");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                displayMainMenu();
            }
            case 4: {
                System.out.println("Thank you for using Toffee!");
                return;
            }
            default: {
                System.out.println("Invalid Choice try again:");
                displayMainMenu();
            }
        }
    }

    public void addToCart(Items item){
        cart.addItem(item);
    }

    public void chooseItemCategory(){
        Catalog catalog = new Catalog();
        System.out.println("\nSpecify your choice: ");
        System.out.println("1. choose Item. \n2. Return to main menu.");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        if(choice == 1){
            System.out.print("Enter Category Name: ");
//            String category = s.nextLine();
//            while(!catalog.getCategories().contains(category)){
//                System.out.print("Invalid category, try again: ");
//                category = s.nextLine();
//            }
        } else {
            displayMainMenu();
        }
    }

    public void chooseItem(){
        Catalog catalog = new Catalog();
        System.out.println("\nSpecify your choice: ");
        System.out.println("1. choose Item. \n2. Return to main menu.");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        if(choice == 1){
            System.out.print("Enter Item number: ");
            int itemChoice = s.nextInt();
            ArrayList<Items> arr = catalog.getItems();
            System.out.print(arr.get(itemChoice));
        } else {
            displayMainMenu();
        }
    }

    public void checkout(){

    }

    public void pay(){

    }

    public static boolean isValid(String input, String regexData)
    {
        String regex = regexData;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}

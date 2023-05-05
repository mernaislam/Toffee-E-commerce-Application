package CustomerDetails;
import ItemCollection.Catalog;
import  OrderDetails.Order;
import Items.Items;
import ShoppingCart.Cart;
import FileIO.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private Account account;
    private int id;
    private Cart cart;
    private ArrayList<Order> orders = new ArrayList<Order>();

    public void login(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your credentials.");
        System.out.print("Username: ");
        String username = s.nextLine();
        System.out.print("Password: ");
        String password = s.nextLine();
        login(username, password);
    }
    public void login(String username, String password){
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
                                break;
                            }
                            cnt--;
                        }
                        if(cnt == 0){
                            System.out.println("Failed to log in");
                            return;
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Welcome to Toffee Application");
        mainMenu();
    }

    public void mainMenu(){
        Scanner s = new Scanner(System.in);
        System.out.println("1. View Catalog (All Items). \n2. View Catalog by Categories. \n3. checkout. \n4. Exit");
        System.out.println("Please enter your choice: ");
        int choice = s.nextInt();
        switch(choice){
            case 1: {
                Catalog catalog = new Catalog();
                catalog.displayAllItems();
                chooseItem();
            }
            case 2: {
                Catalog catalog = new Catalog();
                catalog.displayByCategory();
                chooseItemCategory();
            }
            case 3: {
                System.out.println("Thank you for using Toffee!");
            }
            default: {
                System.out.println("Invalid Choice try again:");
                mainMenu();
            }
        }
    }
    public void register(){
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a username: ");
        String username = s.nextLine();

        // verify username does not exists to prevent duplicates
        ReadingFromFile read = new ReadingFromFile();
        while(read.isEmailExist("CustomerDetails", username)){
            System.out.print("Username already exists, please enter another username: ");
            username = s.nextLine();
        }

        System.out.print("Please enter an email: ");
        String email = s.nextLine();

        // validate email
        while(!isValidEmail(email)){
            System.out.print("Please enter a valid email: ");
            email = s.nextLine();
        }

        System.out.print("Please enter a password: ");
        String pass1 = s.nextLine();

        // regex strong password
        while(!isValidPassword(pass1)){
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
            mainMenu();
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
            mainMenu();
        }
    }

    public void checkout(){

    }

    public void pay(){

    }

    public static boolean isValidEmail(String email)
    {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

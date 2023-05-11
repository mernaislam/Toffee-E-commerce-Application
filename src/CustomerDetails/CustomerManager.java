package CustomerDetails;

import FileIO.ReadingFromFile;
import FileIO.WritingToFile;
import ItemCollection.Catalog;
import ItemCollection.CollectionManager;
import ItemCollection.Items;
import OrderDetails.CoD;
import OrderDetails.Order;
import OrderDetails.PaymentMethod;
import ShoppingCart.Cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerManager {
//    Customer customer = new Customer();
//
//    public boolean login(){
//        Scanner s = new Scanner(System.in);
//        System.out.println("Please enter your credentials.");
//        System.out.print("Username: ");
//        String username = s.nextLine();
//        System.out.print("Password: ");
//        String password = s.nextLine();
//        return login(username, password);
//    }
//
//    public boolean login(String username, String password){
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader("Toffee-E-commerce-Application/CustomerDetails.txt"));
//            String line;
//            boolean found = false;
//            while((line = reader.readLine()) != null){
//                if(line.equals(username)){
//                    found = true;
//                    line = reader.readLine();
//                    if(line.equals(password)){
//                        System.out.println("Successfully Logged in\n");
//                    } else {
//                        int cnt = 3;
//                        while(cnt != 0){
//                            System.out.print("Incorrect Password, please try again: ");
//                            Scanner s = new Scanner(System.in);
//                            password = s.nextLine();
//                            if(line.equals(password)){
//                                System.out.println("Successfully Logged in\n");
//                                return true;
//                            }
//                            cnt--;
//                        }
//                        if(cnt == 0){
//                            System.out.println("Failed to log in");
//                            return false;
//                        }
//                    }
//                }
//            }
//            if(!found){
//                System.out.println("Username not found please try again: ");
//                login();
//            }
//            reader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//    public void register(){
//        Scanner s = new Scanner(System.in);
//        System.out.print("Please enter a username: ");
//        String username = s.nextLine();
//
//        // verify username does not exists to prevent duplicates
//        ReadingFromFile read = new ReadingFromFile();
//        while(read.isEmailExist("CustomerDetails", username) || !isValid(username, "^[a-zA-Z][a-zA-Z0-9_]{6,19}$")){
//            if(read.isEmailExist("CustomerDetails", username)) {
//                System.out.print("Username already exists, please enter another username: ");
//                username = s.nextLine();
//            } else if(!isValid(username, "^[a-zA-Z][a-zA-Z0-9][_?]{6,19}$")) {
//                System.out.print("Invalid format for username (ex: alex_tom): ");
//                username = s.nextLine();
//            } else {
//                break;
//            }
//        }
//
//        System.out.print("Please enter an email: ");
//        String email = s.nextLine();
//
//        // validate email
//        while(!isValid(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
//            System.out.print("Please enter a valid email: ");
//            email = s.nextLine();
//        }
//
//        System.out.print("Please enter a password: ");
//        String pass1 = s.nextLine();
//
//        // regex strong password
//        while(!isValid(pass1, "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20}$")){
//            System.out.print("Please enter a strong password: ");
//            pass1 = s.nextLine();
//        }
//        System.out.print("Please re-enter the password: ");
//        String pass2 = s.nextLine();
//
//        // validate password in re-entering
//        while(!pass1.equals(pass2)){
//            System.out.println("Passwords does not match, please re-enter the passwords:");
//            System.out.print("Please re-enter the password: ");
//            pass2 = s.nextLine();
//        }
//
//        // Address Filling
//        System.out.println("Great, now we need to fill your address!");
//        System.out.print("Governorate: ");
//        String gov = s.nextLine();
//        System.out.print("Street: ");
//        String street = s.nextLine();
//        System.out.print("District: ");
//        String district = s.nextLine();
//        System.out.print("Building Number: ");
//        int buildingNo = s.nextInt();
//        System.out.print("Floor Number: ");
//        int floorNo = s.nextInt();
//        System.out.print("Flat Number: ");
//        int flatNo = s.nextInt();
//
//        Address add = new Address(gov, street, district, buildingNo, floorNo, flatNo);
//        Account acc = new Account(username, email, pass1, add);
//        customer.setAccount(acc);
//        Customer.setId(Customer.getId() + 1);
//        System.out.println("Account is created successfully!\n");
//
//        // Writing data to file
//        WritingToFile writeUsername = new WritingToFile("CustomerDetails", username);
//        WritingToFile writePassword = new WritingToFile("CustomerDetails", pass1);
//        login(username, pass1);
//    }
//
////    public void displayMainMenu() throws IOException {
////        CollectionManager collectionManager = new CollectionManager();
////        BufferedReader read;
////        String strId;
////        String strPrice;
////        String strQuantity;
////        int intId;
////        double doublePrice;
////        int intQuantity;
////        String line;
////        try {
////            read = new BufferedReader(new FileReader("Toffee-E-commerce-Application/ItemFullData.txt"));
////            while((line = read.readLine()) != null){
////                String[] words = line.split("\t\t");
////                strId = words[0];
////                String name = words[1];
////                strPrice = words[2];
////                strQuantity = words[3];
////                String category = words[4];
////                String brand = words[5];
////                intId = Integer.parseInt(strId);
////                doublePrice = Double.parseDouble(strPrice);
////                intQuantity = Integer.parseInt(strQuantity);
////                Items item = new Items(name, doublePrice, intQuantity, category, brand);
////                item.setId(intId);
////                collectionManager.addItemCatalog(item);
////            }
////            read.close();
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////        ArrayList<String> categories = new ArrayList<>();
////        for (Items items: collectionManager.getCategoryItems()) {
////            if(!categories.contains(items.getCategory())){
////                categories.add(items.getCategory());
////            }
////        }
////        for (String category: categories) {
////            Category category1 = new Category();
////            category1.setName(category);
////            for (Items item: collectionManager.getCatalogItems()) {
////                if(item.getCategory().equals(category)){
////                    collectionManager.addItemCategory(item, category1);
////                }
////            }
////            catalog.addCategory(category1);
////        }
////        Scanner s = new Scanner(System.in);
////        System.out.println("1. View Catalog (All Items). \n2. View Catalog by Categories. \n3. checkout. \n4. Exit");
////        System.out.println("Please enter your choice: ");
////        int choice = s.nextInt();
////        switch(choice){
////            case 1: {
////                collectionManager.displayAllItems();
////                System.out.println("\nSpecify your choice: ");
////                System.out.println("1. choose Item to add to cart. \n2. Return to main menu.");
////                choice = s.nextInt();
////                if(choice == 1){
////                    chooseItem(collectionManager.getCatalog());
////                } else if (choice == 2){
////                    displayMainMenu();
////                }
////                return;
////            }
////            case 2: {
////                collectionManager.displayByCategory();
////                System.out.println("\nSpecify your choice: ");
////                System.out.println("1. choose Item to add to cart. \n2. Return to main menu.");
////                choice = s.nextInt();
////                if(choice == 1){
////                    chooseItem(collectionManager.getCatalog());
////                } else if (choice == 2){
////                    displayMainMenu();
////                }
////                return;
////            }
////            case 3: {
////                checkout(collectionManager.getCatalog());
////            }
////            case 4: {
////                System.out.println("Thank you for using Toffee!");
////                return;
////            }
////            default: {
////                System.out.println("Invalid Choice try again:");
////                displayMainMenu();
////            }
////        }
////    }
//
////    public void addToCart(Items item, int quantity){
////        customer.getCart().addItem(item);
////        while(quantity != 0){
////            customer.getCart().addToMap(item);
////            quantity--;
////        }
////    }
//
//    public void chooseItem(Catalog catalog) throws IOException {
//        CollectionManager collectionManager = new CollectionManager();
//        Scanner s = new Scanner(System.in);
//        System.out.print("Enter Item number: ");
//        int itemChoice = s.nextInt();
//        boolean isFound = false;
//        for (Items item: catalog.getItems()) {
//            if(item.getId() == itemChoice){
//                System.out.print("Enter Item Quantity: ");
//                int quantity = s.nextInt();
//                while (quantity > item.getQuantity() || quantity > 50){
//                    System.out.println("Invalid Quantity, maximum quantity available is: " + item.getQuantity() + " (Note: should be less than 50)");
//                    System.out.print("Re-enter Item Quantity: ");
//                    quantity = s.nextInt();
//                }
//                System.out.println("Item: " + item.getName() + " with price " + item.getPrice() + " L.E is added to cart Successfully!\n");
//                isFound = true;
//                addToCart(item, quantity);
//                item.setQuantity(item.getQuantity() - quantity);
//                WritingToFile write = new WritingToFile();
//                String ItemFullData = item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity() + "\t\t" + item.getCategory() + "\t\t" + item.getBrand();
//                String ItemData = item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity();
//                write.updateItemQuantity("ItemList", ItemData, item.getId());
//                write.updateItemQuantity("ItemFullData", ItemFullData, item.getId());
//                break;
//            }
//        }
//        if(!isFound){
//            System.out.println("Invalid Item number, please try again!");
//            chooseItem(catalog);
//        }
//        System.out.println("1. Checkout. \n2. Add another Item  \n3. Return to main menu.");
//        int choice = s.nextInt();
//        if (choice == 1){
//            checkout(catalog);
//        } else if(choice == 2){
//            chooseItem(catalog);
//        } else if(choice == 3){
////            displayMainMenu();
//        }
//    }
//
//    public void checkout(Catalog catalog) throws IOException {
//        Order order = new Order("1", customer.getCart());
//        if(order.displayOrderDetails()){
//            System.out.println("\tNothing in cart for checkout! ");
//            System.out.println("Returning to main menu... ");
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
////            displayMainMenu();
//        } else {
//            customer.getCart().setTotalPrice();
//            System.out.println("Total Price = " + customer.getCart().getTotalPrice() + "\n");
//            Scanner s = new Scanner(System.in);
//            System.out.println("1. Proceed to payment. \n2. Add another item. \n3. Return to main menu");
//            int choice = s.nextInt();
//            if(choice == 1){
//                PaymentMethod paymentMethod = new CoD();
//                paymentMethod.pay(order, this);
//            } else if(choice == 2){
//                chooseItem(catalog);
//            } else if(choice == 3){
////                displayMainMenu();
//            }
//        }
//    }
//
//    public void addOrder(Order order){
//        customer.getOrders().add(order);
//    }
//
    public static boolean isValid(String input, String regexData) {
        Pattern pattern = Pattern.compile(regexData);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
//
//    public void runUserApp() throws IOException {
//        CustomerManager customer = new CustomerManager();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Toffee Application");
//        System.out.println("1. Register. \n2. Login.");
//        System.out.print("Enter Choice: ");
//        int choice = sc.nextInt();
//        while(choice != 1 && choice != 2){
//            System.out.print("Invalid Choice, try again: ");
//            choice = sc.nextInt();
//        }
//        if(choice == 1){
//            customer.register();
//        } else {
//            if(customer.login()){
//                System.out.println("\nWelcome to Toffee Application");
////                customer.displayMainMenu();
//            }
//        }
//    }
//
//    public Cart getCart() {
//        return customer.getCart();
//    }
//
}

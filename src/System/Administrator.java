package System;

import CustomerDetails.Account;
import CustomerDetails.Customer;
import ItemCollection.Catalog;
import ItemCollection.Category;
import Items.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Administrator {
    private Account account;

    public boolean login(){
        return true;
    }
    public boolean login(String username, String password){
        return true;
    }

    public void register(){

    }

    public void displayMainMenu(){
        Catalog catalog = new Catalog();
        Scanner s = new Scanner(System.in);
        System.out.println("1. Add Item to Catalog. \n2. Add Item to Category. \n3. Set Discount. \n4. Exit");
        System.out.println("Please enter your choice: ");
        int choice = s.nextInt();
        switch(choice){
            case 1: {
            }
            case 2: {
            }
            case 3: {
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
    public void setDiscountItem(Items item, double discount){
        item.setDiscountAmount(discount);
    }
    public void setDiscountAllItems(Catalog catalog, double discount){

    }
    public void setDiscountCategory(Category category, double discount){

    }

//    //Needed to view one customer's orders using a function in customer to get the arraylist of orders
//    public void viewCustomerOrders(Customer customer){
//
//    }

//    //Needed to view all orders using a function display all orders in system
//    public void viewAllOrders(SystemManager system){
//        system.displayAllOrders();
//    }
}

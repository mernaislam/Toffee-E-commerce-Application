package System;

import CustomerDetails.Customer;
import ItemCollection.Catalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemManager {
    private ArrayList<Customer> customers;
    private ArrayList<Administrator> administrators;
    public void runUserApp(){
        Customer customer = new Customer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Toffee Application");
        System.out.println("1. Register. \n2. Login.");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();
        while(choice != 1 && choice != 2){
            System.out.print("Invalid Choice, try again: ");
            choice = sc.nextInt();
        }
        if(choice == 1){
            customer.register();
        } else {
            if(customer.login()){
                System.out.println("\nWelcome to Toffee Application");
                customer.displayMainMenu();
            }
        }
    }
    public void runAdminApp() throws IOException {
        Administrator admin = new Administrator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Toffee Application");
//        System.out.println("1. Register. \n2. Login.");
//        System.out.print("Enter Choice: ");
//        int choice = sc.nextInt();
//        while(choice != 1 && choice != 2){
//            System.out.print("Invalid Choice, try again: ");
//            choice = sc.nextInt();
//        }
//        if(choice == 1){
//            admin.register();
//        } else {
//            if(admin.login()){
//                System.out.println("Welcome to Toffee Application");
//                admin.displayMainMenu();
//            }
//        }
        if(admin.login()){
            admin.displayMainMenu();
        };
    }
    public String sendOTP(){
        return "";
    }
    public boolean closeOrder(){
        return false;
    }
//    public void displayAllOrders(){
//
//    }

}

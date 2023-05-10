package View;

import CustomerDetails.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class SystemManager {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Administrator> administrators = new ArrayList<>();
    public void runUserApp() throws IOException {
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
        if(admin.login()){
            admin.displayMainMenu();
        };
    }

    public boolean closeOrder(){
        return false;
    }
//    public void displayAllOrders(){
//
//    }

}

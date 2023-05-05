package CustomerDetails;
import  OrderDetails.Order;
import Items.Items;
import ShoppingCart.Cart;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private Account account;
    private int id;
    private Cart cart;
    private ArrayList<Order> orders;
    public void login(String username, String password){
        // search in a file
    }
    public void register(){
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a username: ");
        String username = s.nextLine();
        System.out.print("Please enter an email: ");
        String email = s.nextLine();
        System.out.print("Please enter a password: ");
        String pass1 = s.nextLine();
        System.out.print("Please re-enter the password: ");
        String pass2 = s.nextLine();
        while(pass1 != pass2){
            System.out.println("Passwords does not match, please re-enter the passwords:");
            System.out.print("Please enter a password: ");
            pass1 = s.nextLine();
            System.out.print("Please re-enter the password: ");
            pass2 = s.nextLine();
        }
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
        // add username and password to a file
    }
    public void addToCart(Items item){
        cart.addItem(item);
    }
    public void checkout(){

    }
    public void pay(){

    }
}

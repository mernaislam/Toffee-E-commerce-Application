package System;

import CustomerDetails.Account;
import CustomerDetails.Customer;
import ItemCollection.Catalog;
import ItemCollection.Category;
import Items.*;


public class Administrator {
    private Account account;
    public void login(String username, String password){

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

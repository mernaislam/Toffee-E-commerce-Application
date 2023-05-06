import CustomerDetails.Customer;
import FileIO.ReadingFromFile;
import FileIO.WritingToFile;
import ItemCollection.Catalog;
import ItemCollection.Category;
import System.SystemManager;
import Items.Items;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static Items.UnitType.Loose;

public class Main {
    public static void main(String[] args) {
//        System.out.println("working");
        Category Chocolates = new Category("Chocolates");
        Items item = new Items("Twix", 30, 50, Loose, Chocolates, "Twix");
        Items item2 = new Items("Galaxy", 40, 50, Loose, Chocolates, "Galaxy");
//        Customer merna = new Customer();
////        merna.register();
//        Catalog c = new Catalog();
//        c.addItem(item);
//        c.addItem(item2);
//        c.displayAllItems();
        //merna.login("mernaislam", "Merna61!!");
//        SystemManager systemManager = new SystemManager();
//        systemManager.run();

    }
}

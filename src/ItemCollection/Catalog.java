package ItemCollection;

import CustomerDetails.Customer;
import FileIO.ReadingFromFile;
import Items.Items;

import java.util.ArrayList;
import java.util.Scanner;


public class Catalog {
    private ArrayList<Items> items = new ArrayList<Items>();
    private ArrayList<Category> categories = new ArrayList<Category>();
    public void addItem(Items item){
        items.add(item);
    }

    public void deleteItem(Items item){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i) == item){
                items.remove(i);
            }
        }
    }

    public void displayByCategory(Catalog catalog){
        for (Category cat: categories) {
            System.out.println("Category: " + cat.getName());
            System.out.println("ID\t\tItem\t\tPrice\t\tQuantity");
            for (Items item: cat.getItems()){
                System.out.println( item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity());
            }
            System.out.println();
        }
    }

    public void displayAllItems(Catalog catalog){
        System.out.println("ID\t\tItem\t\tPrice\t\tQuantity");
        for (Items item: catalog.items){
            System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity());
        }
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void addCategory(Category category){
        categories.add(category);
    }
}

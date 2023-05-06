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

    public void displayByCategory(){
        for (Category category: categories) {
            int cnt = 1;
            System.out.println("Category: " + category.getName());
            System.out.println("Item     Price     Quantity");
            for (Items item: category.getItems()){
                System.out.println(cnt + ". " + item + " " + item.getPrice() + " " + item.getQuantity());
                cnt++;
            }
        }
    }

    public void displayAllItems(){
        System.out.println("ID     Item     Price     Quantity");
        ReadingFromFile read = new ReadingFromFile();
        read.display("ItemList");
//        for (Items item: items){
//            System.out.println(item + " " + item.getPrice() + " " + item.getQuantity());
//        }


    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void addCategory(String name){
        Category category= new Category(name);
        categories.add(category);
    }
}

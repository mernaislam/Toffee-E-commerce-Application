package Items;
import FileIO.WritingToFile;
import ItemCollection.Catalog;
import ItemCollection.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Items {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private UnitType unitType;
    private ArrayList<Category> categories = new ArrayList<Category>();
    private String brand;
    private double discountAmount;
    private ItemStatus itemStatus;
    private String description;


    public Items(String name, double price, int quantity, UnitType unitType, Category category, String brand) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unitType = unitType;
        this.categories.add(category);
        this.brand = brand;
        BufferedReader writer;
        String lastId = null;
        int newId = 0;
        String line;
        try {
            writer = new BufferedReader(new FileReader("Toffee-E-commerce-Application/ItemList.txt"));
            while((line = writer.readLine()) != null){
                String[] words = line.split(" ");
                lastId = words[0];
            }
            if(lastId != null) {
                newId = Integer.parseInt(lastId);
                newId++;
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.id = newId;
        String ItemData = id + "\t" + name + "\t" + price + "\t" + quantity;
        WritingToFile writeItem = new WritingToFile("ItemList", ItemData);
//        Catalog.addItem(this);
    }
//    //Needed if we want to add this item to another category
//    public void addCategory(Category category){
//        categories.add(category);
//        category.addItem(this);
//    }
    public void setItemStatus(ItemStatus itemStatus){
        this.itemStatus = itemStatus;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
        price -= (price*discountAmount);
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
//    //Needed if we want to change the original price of the item
//    public void setPrice(double price) {
//        this.price = price;
//    }
}

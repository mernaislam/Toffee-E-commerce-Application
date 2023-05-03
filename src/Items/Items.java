package Items;
import ItemCollection.Category;

import java.util.ArrayList;

public class Items {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private UnitType unitType;
    private ArrayList<Category> categories;
    private String brand;
    private double discountAmount;
    private ItemStatus itemStatus;
    private String description;


    public Items(int id, String name, double price, int quantity, UnitType unitType, Category category, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unitType = unitType;
        this.categories.add(category);
        this.brand = brand;
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

    //    //Needed if we want to change the original price of the item
//    public void setPrice(double price) {
//        this.price = price;
//    }
}

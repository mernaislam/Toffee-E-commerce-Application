package ItemCollection;
import Items.Items;

import java.util.ArrayList;

public class Category {
    private ArrayList<Items> items;
    private CategoryNames name;
    private double discount;

    public Category(String name){
//        this.name = name;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public CategoryNames getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

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
}

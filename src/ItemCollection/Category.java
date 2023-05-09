package ItemCollection;
import Items.Items;

import java.util.ArrayList;

public class Category {
    private ArrayList<Items> items = new ArrayList<Items>();
    private ArrayList<String> names = new ArrayList<String>();
    private String name;
    private double discount;

    public Category(){}
    public boolean addCategory(String categoryName){
        for (String name: names) {
            if(name.equals(categoryName)){
                return false;
            }
        }
        this.names.add(categoryName);
        this.name = categoryName;
        return true;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public double getDiscount() {
        return discount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public void addItem(Items item){
//        for (String name: names) {
//            if(name.equals(getName())){
//            }
//        }
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

package ItemCollection;

import Items.Items;
import java.util.ArrayList;

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
        for (Category cat: categories) {
            System.out.println("Category: " + cat.getName());
            System.out.println("ID\t\tItem\t\tPrice\t\tQuantity");
            for (Items item: cat.getItems()){
                System.out.println( item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity());
            }
            System.out.println();
        }
    }

    public void displayAllItems(){
        System.out.println("ID\t\tItem\t\tPrice\t\tQuantity");
        for (Items item: items){
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

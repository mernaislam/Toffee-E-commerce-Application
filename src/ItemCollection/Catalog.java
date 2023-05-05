package ItemCollection;

import Items.Items;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Items> items;
    private ArrayList<Category> categories;
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
            System.out.println(category.getName());
            for (Items item: category.getItems()){
                System.out.println(item);
            }
        }
    }

    public void displayAllItems(){
        for (Items item: items){
            System.out.print(item + " " + item.getPrice() + " " + item.getQuantity());
        }
    }

    public void addCategory(String Name){
//        categories.add()
    }
}

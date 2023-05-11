package ItemCollection;

import DataManager.WritingToFile;

import java.util.ArrayList;

public class CollectionManager {
    private Catalog catalog = new Catalog();
    private ArrayList<Category> categorries = new ArrayList<>();

    public void addItemCategory(Items item, Category category){
        category.getItems().add(item);
    }
    public void deleteItemCategory(Items item, Category category){
        for (int i = 0; i < category.getItems().size(); i++) {
            if(category.getItems().get(i) == item){
                category.getItems().remove(i);
            }
        }
    }

    public void addItemCatalog(Items item){
        catalog.getItems().add(item);
    }

    public void deleteItemCatalog(Items item){
        for (int i = 0; i < catalog.getItems().size(); i++) {
            if(catalog.getItems().get(i) == item){
                catalog.getItems().remove(i);
            }
        }
    }

    public void displayByCategory(){
        for (Category cat: catalog.getCategories()) {
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
        for (Items item: catalog.getItems()){
            System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity());
        }
    }

    public void addCategoryToCatalog(Category category){
        catalog.getCategories().add(category);
    }

    public ArrayList<Items> getCategoryItems(Category category){
        return category.getItems();
    }

    public ArrayList<Items> getCatalogItems(){
        return catalog.getItems();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void writeItemToFile(Items item){
        String ItemFullData = item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity() + "\t\t" + item.getCategory() + "\t\t" + item.getBrand();
        String ItemData = item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity();

        WritingToFile writeItem = new WritingToFile("ItemList", ItemData);
        WritingToFile writeFullItem = new WritingToFile("ItemFullData", ItemFullData);
    }

}

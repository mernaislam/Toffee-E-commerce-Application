package ItemCollection;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Items> items = new ArrayList<Items>();
    private ArrayList<Category> categories = new ArrayList<Category>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Items> getItems() {
        return items;
    }
}

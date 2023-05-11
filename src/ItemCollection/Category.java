package ItemCollection;

import java.util.ArrayList;

public class Category {
    private ArrayList<Items> items = new ArrayList<Items>();
    private ArrayList<String> names = new ArrayList<String>();
    private String name;
    private double discount;

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

    public ArrayList<String> getNames() {
        return names;
    }
}

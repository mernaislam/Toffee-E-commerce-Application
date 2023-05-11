package ShoppingCart;
import ItemCollection.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private Double totalPrice = 0.0;
    private ArrayList<Items> items = new ArrayList<Items>();
    private HashMap<Items,Integer> map = new HashMap<Items, Integer>();

    public void setTotalPrice(){
        for (Items item: this.items) {
            totalPrice += item.getPrice() * map.get(item);
        };
    }

    public void setTotalPrice(double val){
        totalPrice = val;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public Integer getMapValue(Items item) {
        return map.get(item);
    }

    public HashMap<Items, Integer> getMap() {
        return map;
    }
}

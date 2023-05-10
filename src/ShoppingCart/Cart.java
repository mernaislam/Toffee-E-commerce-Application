package ShoppingCart;
import Items.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private Double totalPrice = 0.0;
    private ArrayList<Items> items = new ArrayList<Items>();
    private HashMap<Items,Integer> map = new HashMap<Items, Integer>();
    public void addItem(Items item){
        if(!items.contains(item))
            items.add(item);
    }
    public void setTotalPrice(){
        for (Items item: this.items) {
            totalPrice += item.getPrice() * map.get(item);
        };
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

    public void addToMap(Items item){
        map.merge(item, 1, Integer::sum);
        // if key do not exist, put 1 as value
        // otherwise sum 1 to the value linked to key
    }
    public void clearCart(){
        items.clear();
        map.clear();
        totalPrice = 0.0;
    }
}

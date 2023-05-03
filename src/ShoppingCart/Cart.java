package ShoppingCart;
import Items.Items;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Items> items;
    public void addItem(Items item){
        items.add(item);
    }
}

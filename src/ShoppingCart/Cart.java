package ShoppingCart;
import Items.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private Double totalPrice;
    private ArrayList<Items> items = new ArrayList<Items>();
    private HashMap<Items,Integer> map;
    public Cart(){

    }
    public void addItem(Items item){
        items.add(item);
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
}

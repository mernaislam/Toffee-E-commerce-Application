package ShoppingCart;
import ItemCollection.Items;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class representing a shopping cart in an online shopping system.
 */
public class Cart
{
    /**
     * Total price of the cart items
     */
    private Double totalPrice = 0.0;
    /**
     * Cart items
     */
    private ArrayList<Items> items = new ArrayList<Items>();
    /**
     * Cart items and their quantities
     */
    private HashMap<Items,Integer> map = new HashMap<Items, Integer>();
    /**
     * Calculates and sets the total price of the items in the cart.
     */
    public void setTotalPrice()
    {
        for (Items item: this.items)
        {
            totalPrice += item.getPrice() * map.get(item);
        };
    }
    /**
     * Sets the total price of the cart to the specified value.
     *
     * @param val the value to set the total price of the cart to
     */
    public void setTotalPrice(double val)
    {
        totalPrice = val;
    }
    /**
     * Returns the total price of the items in the cart.
     *
     * @return the total price of the items in the cart
     */
    public Double getTotalPrice()
    {
        return totalPrice;
    }
    /**
     * Returns the list of items in the cart.
     *
     * @return the list of items in the cart
     */
    public ArrayList<Items> getItems()
    {
        return items;
    }
    /**
     * Returns the quantity of the specified item in the cart.
     *
     * @param item the item to get the quantity of
     * @return the quantity of the specified item in the cart
     */
    public Integer getMapValue(Items item)
    {
        return map.get(item);
    }
    /**
     * Returns the map of items and their quantities in the cart.
     *
     * @return the map of items and their quantities in the cart
     */
    public HashMap<Items, Integer> getMap()
    {
        return map;
    }
}

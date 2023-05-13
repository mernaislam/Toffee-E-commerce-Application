package ShoppingCart;

import ItemCollection.Items;
/**
 * A class representing a cart manager in an online shopping system.
 */
public class CartManager
{
    Cart cart = new Cart();

    /**
     * Adds the specified item to the map of items and their quantities in the cart.
     * If the item already exists in the map, its quantity is incremented by 1.
     *
     * @param item the item to add to the map
     */
    public void addToMap(Items item)
    {
        cart.getMap().merge(item, 1, Integer::sum);
        // if key do not exist, put 1 as value
        // otherwise sum 1 to the value linked to key
    }
    /**
     * Returns the cart managed by this cart manager.
     *
     * @return the cart managed by this cart manager
     */
    public Cart getCart()
    {
        return cart;
    }
    /**
     * Sets the cart managed by this cart manager to the specified cart.
     *
     * @param cart the cart to set as the cart managed by this cart manager
     */
    public void setCart(Cart cart)
    {
        this.cart = cart;
    }
    /**
     * Clears the cart by removing all items and resetting the total price to zero.
     *
     * @param cart the cart to clear
     */
    public void clearCart(Cart cart)
    {
        cart.getItems().clear();
        cart.getMap().clear();
        cart.setTotalPrice(0.0);
    }
    /**
     * Adds the specified item to the cart.
     *
     * @param item the item to add to the cart
     */

    public void addItem(Items item)
    {
        if(!cart.getItems().contains(item))
            cart.getItems().add(item);
    }
}

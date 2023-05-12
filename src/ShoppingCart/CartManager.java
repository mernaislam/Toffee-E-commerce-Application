package ShoppingCart;

import ItemCollection.Items;

public class CartManager
{
    Cart cart = new Cart();
    public void addToMap(Items item)
    {
        cart.getMap().merge(item, 1, Integer::sum);
        // if key do not exist, put 1 as value
        // otherwise sum 1 to the value linked to key
    }
    public Cart getCart()
    {
        return cart;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }

    public void clearCart(Cart cart)
    {
        cart.getItems().clear();
        cart.getMap().clear();
        cart.setTotalPrice(0.0);
    }
    public void addItem(Items item)
    {
        if(!cart.getItems().contains(item))
            cart.getItems().add(item);
    }
}

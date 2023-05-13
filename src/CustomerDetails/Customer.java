package CustomerDetails;
import OrderDetails.Order;
import ShoppingCart.Cart;
import java.util.ArrayList;

/**
 * This is a class that represents the customer using the system.
 */
public class Customer
{
    /**
     * Account of the customer
     */
    private Account account;
    /**
     * ID of the customer
     */
    private static int id = 0;
    /**
     * Cart of the customer
     */
    private Cart cart = new Cart();
    /**
     * List of orders the customer made
     */
    private ArrayList<Order> orders = new ArrayList<>();

    /**
     * Returns the cart of the customer
     * @return cart of the customer
     */
    public Cart getCart()
    {
        return cart;
    }
    /**
     * Returns the account of the customer
     * @return account of the customer
     */
    public Account getAccount()
    {
        return account;
    }
    /**
     * Sets an account for the customer
     * @param account the username to be set
     */
    public void setAccount(Account account)
    {
        this.account = account;
    }
    /**
     * Returns the ID of the customer
     * @return ID of the customer
     */
    public static int getId()
    {
        return id;
    }
    /**
     * Sets an ID for the customer
     * @param id the username to be set
     */
    public static void setId(int id)
    {
        Customer.id = id;
    }
    /**
     * Returns the list of orders of the customer
     * @return orders of the customer
     */
    public ArrayList<Order> getOrders()
    {
        return orders;
    }
}

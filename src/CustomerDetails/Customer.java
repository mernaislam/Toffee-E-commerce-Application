package CustomerDetails;
import OrderDetails.Order;
import ShoppingCart.Cart;
import java.util.ArrayList;

public class Customer {
    private Account account;
    private static int id = 0;
    private Cart cart = new Cart();
    private ArrayList<Order> orders = new ArrayList<>();

    public Cart getCart() {
        return cart;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Customer.id = id;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}

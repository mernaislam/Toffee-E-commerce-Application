package OrderDetails;
import CustomerDetails.Address;
import ItemCollection.Items;
import ShoppingCart.Cart;
import ShoppingCart.CartManager;

import java.util.Date;
/**
 * A class representing an order in an online shopping system.
 */
public class Order
{
    /**
     * ID of the order
     */
    private String id;
    /**
     * Date of the order
     */
    private Date date;
    /**
     * Total price of the order
     */
    private Double totalPrice;
    /**
     * Shipping address of the order
     */
    private Address shippingAddress;
    /**
     * Cart of the order
     */
    private Cart cart = new Cart();
    /**
     * Payment method of the order
     */
    private PaymentMethod payment;
    /**
     * Order status of the order
     */
    private OrderStatus status;

    /**
     * Constructs a new Order object with the specified ID and Cart.
     *
     * @param id the ID of the order
     * @param cart the cart containing the items in the order
     */
    public Order(String id,Cart cart)
    {
        this.id = id;
        this.cart = cart;
        this.totalPrice = cart.getTotalPrice();
        this.status = OrderStatus.Open;
    }
    /**
     * Sets the date of the order.
     *
     * @param date the date of the order
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Sets the shipping address for the order.
     *
     * @param shippingAddress the shipping address for the order
     */
    public void setShippingAddress(Address shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Sets the status of the order.
     *
     * @param status the status to set for the order
     * @param cart the cart associated with the order
     */
    public void setStatus(OrderStatus status, Cart cart)
    {
        CartManager cartManager = new CartManager();
        this.status = status;
        if(status.equals(OrderStatus.Cancelled))
        {
            cartManager.clearCart(cart);
        }
    }
    /**
     * Sets the payment method for the order.
     *
     * @param payment the payment method for the order
     */

    public void setPayment(PaymentMethod payment)
    {
        this.payment = payment;
    }

    /**
     * Displays the details of the items in the order.
     *
     * @return true if the cart is empty, false otherwise
     */
    public boolean displayOrderDetails()
    {
        boolean isEmpty = true;
        System.out.println("\nYour Cart:");
        System.out.println("\tName\tPrice\tQuantity");
        for (Items item: cart.getItems())
        {
            isEmpty = false;
            System.out.println("\t" + item.getName() + "\t" + item.getPrice() + "\t" + cart.getMapValue(item));
        }
        return isEmpty;
    }
}

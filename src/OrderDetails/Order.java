package OrderDetails;
import CustomerDetails.Address;
import ShoppingCart.Cart;
import java.util.Date;

public class Order {
    private String id;
    private Date date;
    private Double totalPrice;
    private Address shippingAddress;
    private Cart cart;
    private PaymentMethod payment;
    private OrderStatus status;


    public Order(String id,Cart cart){
        this.id = id;
        this.cart = cart;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }
}

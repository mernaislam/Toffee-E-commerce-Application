package OrderDetails;
import CustomerDetails.Account;
import CustomerDetails.Address;
import Items.Items;
import ShoppingCart.Cart;
import java.util.Date;

public class Order {
    private String id;
    private Date date;
    private Double totalPrice;
    private Address shippingAddress;
    private Cart cart = new Cart();
    private PaymentMethod payment;
    private OrderStatus status;
    public Order(String id,Cart cart){
        this.id = id;
        this.cart = cart;
        this.totalPrice = cart.getTotalPrice();
        this.status = OrderStatus.Open;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        if(status.equals(OrderStatus.Cancelled)){
            cart.clearCart();
        }
    }

    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    public boolean displayOrderDetails(){
        boolean isEmpty = true;
        System.out.println("\nYour Cart:");
        System.out.println("\tName\tPrice\tQuantity");
        for (Items item: cart.getItems()) {
            isEmpty = false;
            System.out.println("\t" + item.getName() + "\t" + item.getPrice() + "\t" + cart.getMapValue(item));
        }
        return isEmpty;
    }
}

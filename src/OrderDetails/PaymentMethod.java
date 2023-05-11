package OrderDetails;

import CustomerDetails.CustomerManager;
import java.io.IOException;

public abstract class PaymentMethod {
    public abstract void pay(Order order, CustomerManager customer) throws IOException;
};
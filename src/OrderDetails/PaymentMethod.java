package OrderDetails;

import CustomerDetails.CustomerManager;
import java.io.IOException;

/**
 * A class representing a payment method for an order in an online shopping system.
 */
public abstract class PaymentMethod
{
    /**
     * Processes a payment for an order.
     *
     * @param order the order to be paid
     * @param customer the customer manager for the customer placing the order
     * @throws IOException if an I/O error occurs
     */
    public abstract void pay(Order order, CustomerManager customer) throws IOException;
};
package OrderDetails;
import CustomerDetails.Customer;
import ItemCollection.Category;
import Items.UnitType;
import Items.Items;
import ShoppingCart.Cart;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public abstract class PaymentMethod {
    public abstract void pay(Order order, Customer customer) throws IOException;
};
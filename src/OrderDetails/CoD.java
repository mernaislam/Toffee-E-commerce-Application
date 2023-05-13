package OrderDetails;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import CustomerDetails.CustomerManager;
import AdminDetails.OTPManager;

/**
 * A class representing a cash on delivery payment method for an order.
 */
public class CoD extends PaymentMethod
{
    /**
     * ID of the customer
     */
    private String email;
    /**
     * Sets the email address for the CoD payment method.
     *
     * @param email the email address to set
     */


    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * Returns the email address for the CoD payment method.
     *
     * @return the email address for the CoD payment method
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * Processes a cash on delivery payment for an order.
     *
     * @param order the order to be paid
     * @param customerManager the customer manager for the customer placing the order
     * @throws IOException if an I/O error occurs
     */
    public void pay(Order order, CustomerManager customerManager) throws IOException
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your email: ");
        String email = s.nextLine();
        while(!customerManager.isValid(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
        {
            System.out.print("Please enter a valid email: ");
            email = s.nextLine();
        }
        setEmail(email);
        System.out.println("Verifying your email... ");
        OTPManager otp = new OTPManager();
        int code = OTPManager.generateOTP(8);
        otp.sendOTP(getEmail(), code);
        try
        {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("Enter your OTP number sent to your email: ");
        int OTP = s.nextInt();
        while(OTP != code)
        {
            System.out.print("Invalid OTP, try again: ");
            OTP = s.nextInt();
        }
        System.out.println("Your paying " + customerManager.getCustomer().getCart().getTotalPrice() + " using cash on delivery");
        System.out.println("Do you want to confirm?\n 1. Yes \n 2. No");
        Scanner s2 = new Scanner(System.in);
        int confirm = s2.nextInt();
        while(confirm != 1 && confirm != 2)
        {
            System.out.print("Invalid Choice, try again: ");
            confirm = s.nextInt();
        }
        if(confirm == 1)
        {
            System.out.println("Order placed successfully!");
            customerManager.addOrder(order);
            order.setStatus(OrderStatus.Closed, customerManager.getCustomer().getCart());
        }
        else
        {
            System.out.println("Order Cancelled");
            order.setStatus(OrderStatus.Cancelled, customerManager.getCustomer().getCart());
            customerManager.displayMainMenu();
        }
        System.out.println("Thank you!");
    }
}

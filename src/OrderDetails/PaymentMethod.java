package OrderDetails;
import ItemCollection.Category;
import Items.UnitType;
import Items.Items;
import ShoppingCart.Cart;

import java.util.Random;
import java.util.Scanner;

abstract class PaymentMethod {
    abstract Boolean pay(Order order);
};
class CoD extends PaymentMethod{
    private String phoneNumber;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    Boolean pay(Order order){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your phone number: ");
        String phoneNo = input.nextLine();
        Random rnd = new Random();
        int OTP = rnd.nextInt(900000) + 100000;
        System.out.printf("we have sent an OTP to: %s\n",phoneNo);
        System.out.printf("your OTP is: %d\n",OTP);
        System.out.print("please enter the OTP within 20 seconds: ");
        Long startTime = System.currentTimeMillis();
        int enteredOTP = input.nextInt();
        while (System.currentTimeMillis() - startTime < 20000){
            if(OTP == enteredOTP){
                System.out.print("phone number is added successfully!");
                return true;
            }
            else{
                System.out.print("Invalid OTP,try again: ");
            }
        }
        System.out.print("response failed,OTP is expired");
        return false;
    }
    public static void main(String[] args) {
        Category waffles = new Category("waffles");
        Category candies = new Category("candies");
        Items []items = {new Items("american waffle",20.2,10,"waffles","nutella"),
                new Items("candy bar",10.4,30,"candies","nutella")
        };
        Cart c = new Cart();
        for (int i = 0;i < items.length;i++){
            c.addItem(items[i]);
        }
        for (int i = 0;i < items.length;i++){
            double totalPrice = items[i].getPrice();
            c.setTotalPrice(totalPrice);
        }
        Order order = new Order("1012",c);
        CoD paymentMethod = new CoD();
        paymentMethod.setPhoneNumber("01277557670");
        paymentMethod.pay(order);
    }
}


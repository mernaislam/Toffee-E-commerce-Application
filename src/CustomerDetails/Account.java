package CustomerDetails;

import java.util.ArrayList;

public class Account {
    private String username;
    private String email;
    private String password;
    private ArrayList<Address> addresses;
    public Account(String username, String email, String password, Address address){
        this.username = username;
        this.email = email;
        this.password = password;
        addresses.add(address);
    }
    public void addNewAddress(Address address){
        addresses.add(address);
    }

}

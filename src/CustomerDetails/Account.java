package CustomerDetails;

import java.util.ArrayList;

public class Account {
    private String username;
    private String email;
    private String password;
    private ArrayList<Address> addresses;
    public void addNewAddress(Address address){
        addresses.add(address);
    }

}

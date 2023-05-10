package CustomerDetails;

import java.util.ArrayList;

public class Account {
    private String username;
    private String email;
    private String password;
    private ArrayList<Address> addresses = new ArrayList<Address>();
    public Account(String username, String email, String password, Address address){
        this.username = username;
        this.email = email;
        this.password = password;
        addresses.add(address);
    }
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void addNewAddress(Address address){
        addresses.add(address);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

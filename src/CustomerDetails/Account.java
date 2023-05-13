package CustomerDetails;

import java.util.ArrayList;

/**
 * This is a class that represents the account of the customer or the administrator.
 */
public class Account
{
    /**
     * The username of the account.
     */
    private String username;
    /**
     * The email of the account.
     */
    private String email;
    /**
     * The password of the account.
     */
    private String password;
    /**
     * The list of the addresses in the account.
     */
    private ArrayList<Address> addresses = new ArrayList<Address>();

    /**
     * Account constructor with all fields as parameters
     * @param username the username of the account
     * @param email the email of the account
     * @param password the password of the account
     * @param address the address of the account
     */
    public Account(String username, String email, String password, Address address)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        addresses.add(address);
    }
    /**
     * Account constructor with only two fields as parameters
     * @param username the username of the account
     * @param password the password of the account
     */
    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    /**
     * Adds new address to the list of addresses
     * @param address the address to be added
     */
    public void addNewAddress(Address address)
    {
        addresses.add(address);
    }
    /**
     * Sets a username for the account
     * @param username the username to be set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * Sets a password for the account
     * @param password the username to be set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
}

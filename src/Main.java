import AdminDetails.AdminManager;
import CustomerDetails.CustomerManager;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        CustomerManager customer = new CustomerManager();
        AdminManager adminManager = new AdminManager();
        //adminManager.runAdminApp();
       customer.runUserApp();
    }
}


import System.SystemManager;
import System.OTP_manager;
import System.Administrator;
import Items.Items;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        SystemManager system = new SystemManager();
//        system.runAdminApp();
        system.runUserApp();

        OTP_manager  otp = new OTP_manager();
        int code = otp.generateOTP(4);
        otp.sendOTP("nourmuhammad835@gmail.com", code);
    }

}


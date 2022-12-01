package util;


import org.jboss.aerogear.security.otp.Totp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static base.TestBase.prop;

public class TOTPGenerator {
    public static String key;
    public static String otp;


   /* public static void getTwoFactorCode() {
        // Sample secret key: see http://j.mp/2mOovSV
        String secretKey = "YQVLTX3KR5L4XKVKJ6RPHNY7NTSUEISJMRK5GTO6LYBFA3WHTFRNSFIMUHB5Y3J4ICNJ7DIM3R4YH5M4P5VKTCDH46RR7MPH7DKOU4I";
        Totp totp = new Totp(secretKey);
        String otp = totp.now();
        System.out.println(otp);
    }*/

    public static void returnOTP(String username) {
        String secretKey = getKey(username);
        //String otp = null;
        if (secretKey == null) {
            System.out.println("Please provide a valid email address");
        } else {
            Totp totp = new Totp(secretKey);
            otp = totp.now();
            System.out.println(otp);
        }

    }

    public static String getKey(String username) {
        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (username == "mfa") {
            key = prop.getProperty("firstUserSecret");
        } else if (username == "mfa1") {
            key = "kjlkjk";
        } else {
            key = null;
        }
        return key;
    }


}


package util;


import base.TestBase;
import org.apache.poi.ss.formula.functions.T;
import org.jboss.aerogear.security.otp.Totp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static base.TestBase.prop;

public class TOTPGenerator {
    public static String key;
    public static String otp;
    public static HashMap<String, String> usersMap= new HashMap<>();


   /* public static void getTwoFactorCode() {
        // Sample secret key: see http://j.mp/2mOovSV
        String secretKey = "YQVLTX3KR5L4XKVKJ6RPHNY7NTSUEISJMRK5GTO6LYBFA3WHTFRNSFIMUHB5Y3J4ICNJ7DIM3R4YH5M4P5VKTCDH46RR7MPH7DKOU4I";
        Totp totp = new Totp(secretKey);
        String otp = totp.now();
        System.out.println(otp);
    }*/

    public static void returnOTP(String username) {
        //String secretKey = getKey(username);
        testMap();
        String secretKey= getValuefromMap(username);
        if (secretKey == null) {
            System.out.println("Please provide a valid email address");
        } else {
            Totp totp = new Totp(secretKey);
            otp = totp.now();
            System.out.println(otp);
        }

    }



  /*  public static String getKey(String username) {
        TestBase t1= new TestBase();
        if (username == "mfa") {
            key = prop.getProperty("firstUserSecret");
        } else if (username == "mfa1") {
            key = "kjlkjk";
        } else {
            key = null;
        }
        return key;
    }*/

    public static void testMap(){

        TestBase t1= new TestBase();
        String mapKey= prop.getProperty("farhantest");
        usersMap.put("mfa",mapKey);
        usersMap.put("mfa5","aafasf4545");
        //System.out.println(usersMap);

    }
    public static String getValuefromMap(String username) {
        return usersMap.get(username);
    }

}


package util;

import org.jboss.aerogear.security.otp.Totp;

public class TOTPGenerator {
    public static void getTwoFactorCode() {


        // Sample secret key: see http://j.mp/2mOovSV
        //String secretKey = "6jm7n6xwitpjooh7ihewyyzeux7aqmw2";
        String secretKey = "YQVLTX3KR5L4XKVKJ6RPHNY7NTSUEISJMRK5GTO6LYBFA3WHTFRNSFIMUHB5Y3J4ICNJ7DIM3R4YH5M4P5VKTCDH46RR7MPH7DKOU4I";
        Totp totp = new Totp(secretKey);
        String otp = totp.now();
        //return otp;
        System.out.println(otp);


    }
}


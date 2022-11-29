package util;

import org.jboss.aerogear.security.otp.Totp;

public class TOTPGenerator {
    public static String getTwoFactorCode() {


        // Sample secret key: see http://j.mp/2mOovSV
        String secretKey = "6jm7n6xwitpjooh7ihewyyzeux7aqmw2";
        Totp totp = new Totp(secretKey);
        String otp = totp.now();
        return otp;


    }
}


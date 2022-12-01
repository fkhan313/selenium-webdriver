package util;

import base.TestBase;

public class tester extends TestBase {

    public static void main(String[] args) {
        //TOTPGenerator.getTwoFactorCode();
        System.out.println(TOTPGenerator.returnOTP("mfa"));
        //System.out.println(TOTPGenerator.getKey("mfa"));

    }
}

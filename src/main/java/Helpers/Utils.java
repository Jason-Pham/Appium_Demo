package Helpers;

import org.jboss.aerogear.security.otp.Totp;

import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static String getOTP(String code) {
        //Properties OTP;
        //OTP = PropertiesLoader.load_OTP_Properties();

        //String otpKeyStr = OTP.getProperty(kindOfOTP); // <- this 2FA secret key.

        Totp totp = new Totp(code);
        return totp.now();
    }
}

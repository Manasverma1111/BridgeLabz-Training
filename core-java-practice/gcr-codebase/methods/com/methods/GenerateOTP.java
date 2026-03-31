package com.methods;
import java.util.Arrays;

public class GenerateOTP {
//    method to generate a 6-digit OTP
    public static int generateOTP() {

        return (int) (Math.random() * 900000) + 100000;
    }
//    method to check uniqueness of OTP array
    public static boolean areOTPsUnique(int[] otps) {

        for (int i = 0; i < otps.length - 1; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] otpArray = new int[10];
        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }
//        function call and display output
        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));
        if (areOTPsUnique(otpArray)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Duplicate OTPs found!");
        }
    }
}


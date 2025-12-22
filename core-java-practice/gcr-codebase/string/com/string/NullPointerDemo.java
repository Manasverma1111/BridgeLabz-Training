package com.string;
public class NullPointerDemo {
//    function to generate exception
    public static void genEx() {

        String s = null;
        int length = s.length();
    }
//    function to handle exception
    public static void handleEx() {

        String s = null;

        try {
            int length = s.length();
        } catch (NullPointerException e) {
            System.out.println("Handled in handleEx()");
        }
    }
    public static void main(String[] args) {

        try {
            genEx();
        } catch (NullPointerException e) {
            System.out.println("Caught from genEx(): " + e.getMessage());
        }

        handleEx();
    }
}


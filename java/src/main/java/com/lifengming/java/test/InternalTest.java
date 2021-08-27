package com.lifengming.java.test;

/**
 * @author lifengming
 * @date 2021.08.26
 */
public class InternalTest {
    public static void main(String[] args) {
        System.out.println(1 << (32 - Integer.numberOfLeadingZeros(8 - 1)));
        System.out.println(1 << (32 - Integer.numberOfLeadingZeros(7 - 1)));
        System.out.println(1 << (32 - Integer.numberOfLeadingZeros(6 - 1)));
        System.out.println(1 << (32 - Integer.numberOfLeadingZeros(5 - 1)));
        System.out.println(1 << (32 - Integer.numberOfLeadingZeros(4 - 1)));


        System.out.println((8 - 1) << 1);
        System.out.println((16 - 1) << 1);
    }
}

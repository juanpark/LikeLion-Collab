package com.test;

public class Test03 {
    public static void main(String[] args) {
        int a = 51;
        int b = 240;

        Integer A = a;  // Auto-boxing (not necessary, but works)
        Integer B = b;

        System.out.println("Binary of a: " + Integer.toBinaryString(A));
        System.out.println("Binary of b: " + Integer.toBinaryString(B));

        System.out.println("AND = " + Integer.toBinaryString(a & b) + " (" + (a & b) + ")");
        System.out.println("OR  = " + Integer.toBinaryString(a | b) + " (" + (a | b) + ")");
        System.out.println("XOR = " + Integer.toBinaryString(a ^ b) + " (" + (a ^ b) + ")");
    }
}
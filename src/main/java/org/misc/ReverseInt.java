package org.misc;

public class ReverseInt {
    public static int reverse(int number) {
        int reversedNumber = 0;
         number = Math.abs(number);

        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return reversedNumber;
    }

    public static void main(String[] args) {
        int number = -123;
        System.out.println(" Reversed number is : " + reverse(number));
    }
}
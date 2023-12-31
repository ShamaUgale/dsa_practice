package org.dsa.strings;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            // converting the char to number = char 0 - 0 is 0 , char 1 - 0 is 0
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
            }

            sb.append(sum % 2); // coz 1+1 becomes 2 but in binary it shud be 0
            carry = sum / 2;

            i--;
            j--;

        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        System.out.println("Sum of a=" + a + " & b="+b + " is == " + addBinary(a, b));
    }
}
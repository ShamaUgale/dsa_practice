package org.dsa.strings;

import java.util.Arrays;

public class LicenseKeyFormatting {

    /*
    You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.



Example 1:

Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
Explanation: The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:

Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.

     */

    public static String LicenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int charLen = 0;
        for (int i = S.length() - 1; i >= 0; i--){
            if (S.charAt(i) != '-') {
                if (charLen > 0 && charLen % K == 0) {
                    sb.append('-');
                }
                sb.append(S.charAt(i));
                charLen++;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(LicenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(LicenseKeyFormatting("2-5g-3-J", 2));
    }
}

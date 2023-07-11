package org.dsa.strings;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 */
public class IsSubsequence {

    public static boolean isSubsequesceOf(String s, String t) {

        if (null == s || null == t || s.length() == 0 || t.length() == 0) {
            return false;
        }

        int indexS = 0;
        int indexT = 0;

        while (indexT < t.length()) {

            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                if (s.length() == indexS) {
                    return true;
                }
            }
            indexT++;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequesceOf("abc", "ahbgdc"));//t
        System.out.println(isSubsequesceOf("axc", "ahbgdc")); ///f

    }
}

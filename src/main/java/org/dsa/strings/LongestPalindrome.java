package org.dsa.strings;

import java.util.HashSet;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 */
public class LongestPalindrome {

    public static int buildLongestPalindromeWith(String s){
        if(s==null || s.length()==0)
            return 0;

        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(hs.contains(c)){
                hs.remove(c);
                count++;
            }else{
                hs.add(c);
            }
        }

        if(hs.isEmpty())
            return count*2;
        else
            return count*2+1;
    }


    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println("Longest palindrome that can be built for " + s + " is of length : " + buildLongestPalindromeWith(s));
    }
}

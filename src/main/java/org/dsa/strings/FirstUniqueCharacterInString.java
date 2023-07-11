package org.dsa.strings;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 */
public class FirstUniqueCharacterInString {

    public static int firstUniqueChar(String s){
        int freq [] = new int[26];

        for(int i = 0; i < s.length(); i ++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i ++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(firstUniqueChar("loveleetcode"));
    }
}

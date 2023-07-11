package org.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class MagazineAndRansomnote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magM = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int newCount = magM.getOrDefault(c, 0) + 1;
            magM.put(c, newCount);
        }
        for (char c : ransomNote.toCharArray()) {
            int newCount = magM.getOrDefault(c, 0) - 1;
            if (newCount < 0)
                return false;
            magM.put(c, newCount);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}

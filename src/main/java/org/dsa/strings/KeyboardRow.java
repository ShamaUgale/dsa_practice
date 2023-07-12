package org.dsa.strings;

import java.util.ArrayList;
import java.util.HashMap;

/*
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 */
public class KeyboardRow {

    public static String[] findWords(String[] words) {
        String arr1[] = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        String arr2[] = {"a", "s", "d", "f", "g", "h", "j", "k", "l"};
        String arr3[] = {"z", "x", "c", "v", "b", "n", "m"};
        HashMap map = new HashMap();
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            map.put(arr1[i], 1);
        }
        for (int i = 0; i < 9; i++) {
            map.put(arr2[i], 2);
        }
        for (int i = 0; i < 7; i++) {
            map.put(arr3[i], 3);
        }

        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (map.get("" + words[i].toLowerCase().charAt(0)) != map.get("" + words[i].toLowerCase().charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(words[i]);
            }
        }
        String[] ans = new String[list.size()];
//        System.out.println(map);
        return (String[]) list.toArray(ans);
    }

    public static void main(String[] args) {
        String[] list = {"Hello","Alaska","Dad","Peace"};
        String[] ans = findWords(list);

        for (String s : ans){
            System.out.println(s);
        }
    }

}

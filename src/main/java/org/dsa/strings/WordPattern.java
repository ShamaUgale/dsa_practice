package org.dsa.strings;

import java.util.HashMap;
import java.util.Map;

class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if(array.length != pattern.length()) return false;

        Map<Character, String> c2s = new HashMap<Character, String>();
        Map<String, Character> s2c = new HashMap<String, Character>();

        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String str = array[i];
            if(!c2s.containsKey(c)){
                c2s.put(c,str);
            }
            if(!s2c.containsKey(str)){
                s2c.put(str,c);
            }
            if(!c2s.get(c).equals(str) || !s2c.get(str).equals(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abca", "queen king lion queen"));
        System.out.println(wordPattern("abba", "queen king king queen"));
        System.out.println(wordPattern("abba", "queen king lion queen"));


    }
}
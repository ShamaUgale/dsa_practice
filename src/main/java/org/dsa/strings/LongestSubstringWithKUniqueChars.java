package org.dsa.strings;

import java.util.HashMap;

public class LongestSubstringWithKUniqueChars {

    public static void main(String[] args) {
        System.out.println("The longest substring len : "+longestkSubstr("aa",2));
        System.out.println("The max fruits are : "+longestkSubarrayWithKUniqueNumbers(new int[]{1,1},2));

    }

        public static int longestkSubstr(String s, int k) {
            HashMap<Character,Integer> charMap=new HashMap<>();
            int i =0;
            int j =0;
            int maxStringlen = Integer.MIN_VALUE;
            while(j<s.length()){
                char ch=s.charAt(j);
                charMap.put(ch, charMap.getOrDefault(ch, 0)+1);

                if(charMap.size()<k){
                    j++;
                }
                else if(charMap.size()==k){
                    maxStringlen=Math.max(maxStringlen,j-i+1);
                    j++;
                }
                else if(charMap.size()>k ){
                    while(charMap.size()>k){

                        if(charMap.containsKey(s.charAt(i))){
                            int freq=charMap.get(s.charAt(i));
                            freq--;
                            charMap.put(s.charAt(i),freq);
                        }
                        if(charMap.get(s.charAt(i))==0){
                            charMap.remove(s.charAt(i));
                        }
                        i++;
                    }
                    j++;
                }
            }
            System.out.println("The no of unique chars are : " + charMap.size());
            return (charMap.size()<k)? 0: maxStringlen;
        }

    public static int longestkSubarrayWithKUniqueNumbers(int[] fruits, int k) {
        HashMap<Integer,Integer> charMap=new HashMap<>();
        int i =0;
        int j =0;
        int maxStringlen = Integer.MIN_VALUE;
        while(j< fruits.length){
            int ch=fruits[j];
            charMap.put(ch, charMap.getOrDefault(ch, 0)+1);

            if(charMap.size()<k){
                j++;
            }
            else if(charMap.size()==k){
                maxStringlen=Math.max(maxStringlen,j-i+1);
                j++;
            }
            else if(charMap.size()>k ){
                while(charMap.size()>k){

                    if(charMap.containsKey(fruits[i])){
                        int freq=charMap.get(fruits[i]);
                        freq--;
                        charMap.put(fruits[i],freq);
                    }
                    if(charMap.get(fruits[i])==0){
                        charMap.remove(fruits[i]);
                    }
                    i++;
                }
                maxStringlen=Math.max(maxStringlen,j-i+1);

                j++;
            }
        }
//        System.out.println("The no of unique fruits are : " + charMap.size());
        return maxStringlen;
    }
}
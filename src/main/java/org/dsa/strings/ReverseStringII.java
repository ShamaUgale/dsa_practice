package org.dsa.strings;

public class ReverseStringII {
/*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.



Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 */
    public static String reverseStr(String s, int k) {
        if(k == 0){
            return s;
        }


        if(s == null || s.length() == 0){
            return s;
        }

        char[] char_arr =s.toCharArray();

        for(int i = 0; i< s.length() ; i = i+ (2*k)){ // jump loop by k
            int start = i;

            // end is k chars na , so i+k-1 , -1 coz we start from 0
            //but wee need to see if thre are last chars which remian less than k
            // so take wichever is min bewteen that k window or the last char
            int end = Math.min(i+k, s.length()) - 1;
            reverse(char_arr, start, end);
        }

        return new String(char_arr);
    }

    private static void reverse(char[] arr , int start, int end){
        char temp;
        while(start <= end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }


    public static void main(String[] args) {

        System.out.println(reverseStr("abcdefg", 2));
    }
}

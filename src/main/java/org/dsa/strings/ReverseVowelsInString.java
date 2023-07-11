package org.dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseVowelsInString {

    public static String reverse(String str){
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] arr = str.toCharArray();

        int start =0;
        int end = str.length()-1;

        while(start <= end){
            if(!vowels.contains(arr[start])){
                start++;
            }else if(!vowels.contains(arr[end])){
                end--;
            }else{
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }


        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }

}

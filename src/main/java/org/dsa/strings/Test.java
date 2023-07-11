package org.dsa.strings;
//input string = aabbbccccaaa, maintain the insertion order and output should be a2b3c4a3

public class Test {

    public static void process(String mystring) {
        StringBuilder sb = new StringBuilder();
        char[] mychar = mystring.toCharArray();
        int count = 1;
        for (int i = 0; i < (mychar.length) - 1; i++) {
            if (mychar[i] == mychar[i + 1]) {
                count = count + 1;
            } else {
                sb.append(mychar[i]);
                sb.append(count);
                count = 1;
            }
            if (i == (mychar.length) - 2) {
                sb.append(mychar[i + 1]);
                sb.append(count);
            }
        }
        System.out.println(sb.toString());
    }

    public static  String myOutput(String str) {
        if (str == null || str.length() == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char currentChar;

        for (int i = 0; i < str.length() - 1; i++) {
            currentChar = str.charAt(i);
            if (currentChar == str.charAt(i+1)) {
                count++;
            } else {
                sb.append(currentChar);
                sb.append(String.valueOf(count));
                count = 1;
            }
        }

        sb.append(str.charAt(str.length()-1));
        sb.append(String.valueOf(count));

        return sb.toString();
    }

    public static void main(String[] args) {
        process("aabbbccccaaa");
        System.out.println(myOutput("aabbbccccaaaaaab"));

    }

}
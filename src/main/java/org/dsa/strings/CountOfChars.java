package org.dsa.strings;


public class CountOfChars {
    // input string = aabbbccccaaa, maintain the insertion order and output should be a2b3c4a3
    public static String countChars(String str) {
        if (str == null || str.length() == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char currentChar;

        for (int i = 0; i < str.length() - 1; i++) {
            currentChar = str.charAt(i);
            if (currentChar == str.charAt(i + 1)) {
                count++;
            } else {
                sb.append(currentChar);
                sb.append(String.valueOf(count));
                count = 1;
            }
        }

        sb.append(str.charAt(str.length() - 1));
        sb.append(String.valueOf(count));

        return sb.toString();
    }

    public static void main(String[] args) {
        countChars("aabbbccccaaa");
    }
}

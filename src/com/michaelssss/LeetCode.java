package com.michaelssss;

/**
 * Created by michaelssss on 2018/1/4.
 */
public class LeetCode {
    static String s = "a";

    public static void main(String[] aaaaa) throws Exception {
        char[] chars = s.toCharArray();
        int maxLen = 0;
        for (int start = 0, end = 0; end < chars.length && start < chars.length; ) {
            if (isWithOutRepeatingChar(chars, start, end)) {
                maxLen = Math.max(maxLen, getSubString(chars, start, end).length);
                end++;
            } else {
                start++;
            }
        }
        System.out.println(maxLen);

    }

    private static char[] getSubString(char[] chars, int start, int end) {
        char[] chars1 = new char[end - start];
        System.arraycopy(chars, start, chars1, 0, end - start);
        return chars1;
    }

    private static boolean isWithOutRepeatingChar(char[] chars, int start, int end) {
        int[] map = new int[256];
        for (; start < end; start++) {
            if (map[chars[start]] == 0) {
                map[chars[start]]++;
            } else {
                return false;
            }
        }
        return true;
    }
}

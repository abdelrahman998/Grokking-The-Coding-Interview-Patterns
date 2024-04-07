package SlidingWindow;

/*
Given a string, find the length of the longest substring in it
with no more than K distinct characters.

 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKDistinct {

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
    }

    public static int findLength(String str, int k) {
        if(str == null || str.isEmpty() || str.length() < k) {
            throw new IllegalArgumentException();
        }
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            // shrink the sliding window, until we are left with 'k' distinct characters in the freq map
            while (charFrequency.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }



}

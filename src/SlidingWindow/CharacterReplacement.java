package SlidingWindow;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement #
Given a string with lowercase letters only,
if you are allowed to replace no more than ‘k’ letters with any letter,
find the length of the longest substring having the same letters after replacement.

Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */

public class CharacterReplacement {

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
    }

    public static int findLength(String str, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from start to end, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means ew can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times, and the remaining letters we should replace.
            // if the remaining letter are more than 'k', it is the time to shrink the window as we are
            // not allowed to replace more than 'k' letters.
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

}

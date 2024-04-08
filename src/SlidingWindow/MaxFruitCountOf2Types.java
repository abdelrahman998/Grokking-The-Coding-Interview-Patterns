package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static void main(String[] args) {

        System.out.println("max number of fruits: " + findLength(new char[] {'A', 'B', 'C', 'A', 'C'}));

    }

    public static int findLength(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> fruitMapFreq = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitMapFreq.put(arr[windowEnd], fruitMapFreq.getOrDefault(arr[windowEnd], 0) + 1);
            while (fruitMapFreq.size() > 2) {
                fruitMapFreq.put(arr[windowStart], fruitMapFreq.getOrDefault(arr[windowStart], 0) - 1);
                if (fruitMapFreq.get(arr[windowStart]) == 0) {
                    fruitMapFreq.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}

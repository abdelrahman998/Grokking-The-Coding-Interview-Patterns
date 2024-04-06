package SlidingWindow;

/*
Given an array of positive numbers and a positive number ‘S’,
find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
Return 0, if no such subarray exists.
 */

public class MinSizeSubArraySum {

    public static void main(String[] args) {

        int result = findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println(result);
    }

    public static int findMinSubArray(int s, int[] arr) {

        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            // shrink the window as small as possible util the 'windowSum' is smaller than 's'
            while (windowSum >= s) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart++];
            }
        }
        return minLength;
    }

}

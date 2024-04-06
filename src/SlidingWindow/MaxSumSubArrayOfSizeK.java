package SlidingWindow;

/*
Given an array of positive numbers and a positive number ‘k’,
find the maximum sum of any contiguous subarray of size ‘k’.
 */

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {

        System.out.println(findMaxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }


    public static int findMaxSumSubArray(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart++];
            }
        }
        return maxSum;
    }

    public static int findMaxSumSubArrayBruteForce(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

}

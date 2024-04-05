package SlidingWindow;

import java.util.Arrays;

/*
Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */

public class AverageOfSubarrayOfSizeK {

    public static void main(String[] args) {

        double[] result = findAverage(5, new int[] {1,3,2,6, -1, 4, 1, 8, 2});
        System.out.println(Arrays.toString(result));

    }

    public static double[] findAverage(int k , int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if ( windowEnd >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart++];
            }
        }
        return result;
    }

    public static double[] findAverageBruteForce(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        for(int i = 0; i <= arr.length - k; i++){
            double sum = 0;
            for (int j = i; j < i + k; j++){
                sum += arr[j];
            }
            result[i] = sum / arr.length;
        }
        return result;
    }






}

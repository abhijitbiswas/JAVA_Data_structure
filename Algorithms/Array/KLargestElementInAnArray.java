package Algo;
//k largest(or smallest) elements in an array
/*
Abhijit.Biswas
Question: Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.
For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements i.e., k = 3 then
your program should print 50, 30 and 23.
Time complexity: O(nlogn)
*/

import java.util.Arrays;
import java.util.Collections;

public class KLargestElementInAnArray {
    public static void kLargest(Integer[] arr, int k) {
        // Sort the given array arr in reverse order
        // This method doesn't work with primitive data
        // types. So, instead of int, Integer type
        // array will be used
        Arrays.sort(arr, Collections.reverseOrder());

        // Print the first kth largest elements
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 23, 12, 9,
                30, 2, 50};
        int k = 3;
        kLargest(arr, k);
    }
}

//
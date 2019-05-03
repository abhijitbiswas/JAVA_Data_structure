package Algo;

import java.util.Arrays;

/**
 * Abhijit.Biswas
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 * Example:
 * <p>
 * Input: arr[] = {3, 1, 4, 6, 5}
 * Output: True
 * There is a Pythagorean triplet (3, 4, 5).
 * <p>
 * Input: arr[] = {10, 4, 6, 12, 5}
 * Output: False
 * There is no Pythagorean triplet.
 */

public class PythagoreanTriplet {
    /**
     * Solution algorithm
     * We can solve this in O(n2) time by sorting the array first.
     * <p>
     * 1) Do square of every element in input array. This step takes O(n) time.
     * <p>
     * 2) Sort the squared array in increasing order. This step takes O(nLogn) time.
     * <p>
     * 3) To find a triplet (a, b, c) such that a2 = b2 + c2, do following.
     * <p>
     * Fix ‘a’ as last element of sorted array.
     * Now search for pair (b, c) in subarray between first element and ‘a’. A pair (b, c) with given sum can be found in O(n) time using meet in middle algorithm discussed in method 1 of this post.
     * If no pair found for current ‘a’, then move ‘a’ one position back and repeat step 3.2.
     * o(n^)
     */

    static boolean isTriplet(int arr[], int n) {
        // Square array elements
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];

        // Sort array elements
        Arrays.sort(arr);

        // Now fix one element one by one and find the other two
        // elements
        for (int i = n - 1; i >= 2; i--) {
            // To find the other two elements, start two index
            // variables from two corners of the array and move
            // them toward each other
            int l = 0; // index of the first element in arr[0..i-1]
            int r = i - 1; // index of the last element in arr[0..i-1]
            while (l < r) {
                // A triplet found
                if (arr[l] + arr[r] == arr[i])
                    return true;

                // Else either move 'l' or 'r'
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }

        // If we reach here, then no triplet found
        return false;
    }


    // Driver program to test above function
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5};
        int arr_size = arr.length;
        if (isTriplet(arr, arr_size) == true)
            System.out.println("Yes Present");
        else
            System.out.println("No Not present");
    }
}


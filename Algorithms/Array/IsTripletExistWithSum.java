package Algo;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Abhijit.Biswas
 * Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, then print the triplet and return true. Else return false.
 * For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9) present in array whose sum is 24.
 */
public class IsTripletExistWithSum {
    /**
     * o(n^)
     * But no space complexity
     *
     * Sort The array
     *
     * for (i = 0 -> arrayLength – 1)
     *
     * pairSum = sum – arr[i]
     *
     * left = i + 1, right = arrayLength – 1
     *
     * while(left < right)
     *
     * if(arr[left] + arr[right] == pairSum)
     *
     * return true
     *
     * if(arr[left] + arr[right] < pairSum)
     *
     * left ++
     *
     * if(arr[left] + arr[right] > pairSum)
     *
     * right —
     *
     * end of all loops
     *
     * return false
     */
    static boolean find3NumbersWithoutSpaceCOmplexity(int arr[],
                                                      int sum) {
        Arrays.sort(arr);
        int left, right;
        for (int i = 0; i < arr.length - 2; i++) {
            left = i + 1;
            right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] == sum) {
                    System.out.println("\n Triplet is withou hashset :" + arr[i] + " " + arr[left] + " " + arr[right]);
                    return true;
                } else {
                    if (arr[i] + arr[left] + arr[right] < sum)
                        left++;
                    else
                        right--;
                }
            }
        }
        return false;}
    /**
     * o(n^)
     * But space taking o(n)
     * Algo:
     * for (i = 0 -> arrayLength – 1)
     * <p>
     * pairSum = sum – arr[i]
     * <p>
     * for(j = i+1 -> arrayLength)
     * <p>
     * {if(hashset.Contains(pairSum – arr[j]))
     * <p>
     * return true;
     * <p>
     * hashSet.Add(arr[j])
     * <p>
     * }
     * <p>
     * at the end of all loops
     * <p>
     * return false
     */

    static boolean find3NumbersWithHashset(int A[],
                                           int arr_size, int sum) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {
            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf("Triplet is %d, %d, %d", A[i],
                            A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }
        // If we reach here, then no triplet was found
        return false;
    }

    /* Driver code */
    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int arr_size = A.length;

        find3NumbersWithHashset(A, arr_size, sum);
        find3NumbersWithoutSpaceCOmplexity(A, sum);
    }
}

package Algo;

import java.util.HashMap;

public class FrequencyInArray {
//Count frequencies of all elements in array
    // O(1) time. , space complexity is there
    HashMap<Integer, Integer> hm=null;
    public void countFreq(int a[], int n) {
        hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            if (hm.containsKey(a[i]))
                hm.put(a[i], hm.get(a[i]) + 1);
            else hm.put(a[i], 1);

        hm.forEach((k,v) -> System.out.println("Key = "
             + k + ", Value = " + v));
        // using keySet() for iteration over keys
       /* for (int value : hm.keySet())
            System.out.println("value is :" + value + " count is:" + hm.get(value));
*/
    }

    public static void main(String[] args) {
        FrequencyInArray feqArr = new FrequencyInArray();
        int a[] = {1, 3, 2, 4, 2, 1};
        int n = a.length;
        feqArr.countFreq(a, n);

    }
}

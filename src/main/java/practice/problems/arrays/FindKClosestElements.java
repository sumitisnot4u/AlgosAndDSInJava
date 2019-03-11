package practice.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]
 Note:
 The value k is positive and will always be smaller than the length of the sorted array.
 Length of the given array is positive and will not exceed 104
 Absolute value of elements in the array and x will not exceed 104
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while(left < right) {
            int mid = (left+right)/2;
            if(x - arr[mid] > arr[mid+k] - x) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++) {
            result.add(arr[i+left]);
        }

        return result;
    }
}

package practice.otherProblems.array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p/>
 * You may assume no duplicate exists in the array.
 *
 * @author Yashraj R. Sontakke
 */
public class SearchInRotatedArray2 {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        if(nums[left] == target){
            return true;
        }else if (nums[right] == target){
            return true;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[left] < nums[mid]) {
            if (nums[left] < target && target < nums[mid]) {
                return search(nums, target, left, mid - 1);
            } else {
                return search(nums, target, mid + 1, right);
            }
        } else if(nums[left] > nums[mid]){
            if (nums[mid] < target && target < nums[right]) {
                return search(nums, target, mid + 1, right);
            } else {
                return search(nums, target, left, mid - 1);
            }
        }else if(nums[left] == nums[mid]){
            if(nums[mid] != nums[right]){
                return search(nums, target, mid + 1, right);
            }else{
                if( search(nums, target, left, mid - 1)){
                    return true;
                }
                return search(nums, target, mid + 1, right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedArray2 findXSortedRotatedArray = new SearchInRotatedArray2();
//        int[] input = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
//        System.out.println(findXSortedRotatedArray.search(input, 5));


        int[] input1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findXSortedRotatedArray.search(input1, 0));
    }
}

package practice.otherProblems;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

 * For example, given array S = {-1 2 1 -4}, and target = 1.

 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author Yashraj R. Sontakke
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            int j=i+1;
            int k = num.length-1;
            while(j<k){
                int sum = num[i] + num[j] + num[k];

                int diff = Math.abs(target - sum);
                if(diff == 0){
                    return target;
                }
                if(diff < min){
                    min = diff;
                    result = sum;
                }
                if(sum <= target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        ThreeSumClosest t = new ThreeSumClosest();
        int[] input = {-1, 2, 1, -4};
        System.out.println(t.threeSumClosest(input, 1));
    }
}

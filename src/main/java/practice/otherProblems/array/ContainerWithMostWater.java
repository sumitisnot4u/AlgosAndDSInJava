package practice.otherProblems.array;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * @author Yashraj R. Sontakke
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left < max){
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    // ?
    public static void main(String[] args){
        ContainerWithMostWater c= new ContainerWithMostWater();
        int[] height = {1, 2, 3, 2, 3, 1, 5, 4};
        System.out.println(c.maxArea(height));
    }
}
/*
 * Trapping Rain Water
Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

 

Constraints:

    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105


 */

public class TrappingRainwater
{
    private static int[] greaterOnLeft(int a[]){
        int ans[] = new int[a.length];
        
        int max = 0;
        for(int i = 0; i < a.length; i++){
            max = Math.max(max, a[i]);
            ans[i] = max;
        }
        return ans;
    }
    
    private static int[] greaterOnRight(int a[]) {
        int ans[] = new int[a.length];
        
        int max = 0;
        for(int i = a.length-1; i >= 0; i--){
            max = Math.max(max, a[i]);
            ans[i] = max;
        }
        return ans;
    }
    
    
    private static int trap(int[] height) {
        
        int left[] = greaterOnLeft(height);
        int right[] = greaterOnRight(height);
        
        int water = 0;
        for(int i = 0; i < height.length; i++){
            water+=Math.min(left[i], right[i])-height[i];
        }
        return water;
    }

    public static void main(String args[])
    {
        int heights[] = {0,1,2,1,4,0,2,1};
        System.out.println(trap(heights));
    }
}
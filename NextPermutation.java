public class NextPermutation
{
    private static void swap(int a[], int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private static void reverse(int a[], int i, int j){
        while(i < j){
            swap(a, i, j);
            i++;
            j--;
        }
    }
    
    //TC - O(n)
    //SC - O(1)
    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0){
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }

    public static void display(int a[])
    {
        for(int i : a) 
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int a[] = {1,2,3};
        nextPermutation(a);
        display(a);
    }    
}

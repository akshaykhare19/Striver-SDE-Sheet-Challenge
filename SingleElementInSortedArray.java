public class SingleElementInSortedArray
{
    //TC - O(logn)
    private static int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length-2;
        while(lo<=hi){
            int mid = (lo+hi)>>1;
            if(nums[mid]==nums[mid^1]){
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return nums[lo];

        /*
        For left half
        Odd index -> 2nd instance
        Even index -> 1st instance

        in case of an odd mid, mid^1 give its prev even index
        in case of an even mid, mid^1 give its next odd index
         */


    }

    //TC - O(n)
    private static int singleNonDuplicateBrute(int[] nums) {
        int xor = 0;
        for(int i : nums){
            xor^=i;
        }
        return xor;
    }

    public static void main(String args[])
    {
        int a[] = {1,1,2,3,3,4,4,5,5};
        System.out.println(singleNonDuplicateBrute(a));
        System.out.println(singleNonDuplicate(a));
    }    
}

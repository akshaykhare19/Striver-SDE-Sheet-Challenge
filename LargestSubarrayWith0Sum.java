import java.util.*;
public class LargestSubarrayWith0Sum
{
    private static int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr = 0, len = 0, l = 0;
        for(int i = 0; i < n; i++){
            curr+=arr[i];
            
            if(curr==0){
                l = i+1;
            }
            
            else if(map.containsKey(curr)){
                int j = map.get(curr)+1;
                l = i-j+1;
            }
            
            else map.put(curr, i);
            len = Math.max(len, l);
        }
        return len;
    }

    public static void main(String args[])
    {
        int a[] = {15,-2,2,-1,1,-15,4};
        System.out.println(maxLen(a, 7));
    }
}
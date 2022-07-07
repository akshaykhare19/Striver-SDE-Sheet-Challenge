import java.util.*;

public class TwoSum
{
    private static int[] brute(int a[], int target)
    {
        int ans[] = new int[2];

        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i]+a[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    
    private static int[] better(int a[], int target)
    {
        int ans[] = new int[2];

        Arrays.sort(a);

        int l = 0, r = a.length-1;
        while(l < r){
            if(a[l] + a[r] == target){
                ans[0] = l;
                ans[1] = r;
                return ans;
            }
            else if(a[l] + a[r] > target) r--;

            else l++;
        }

        return ans;
    }
    
    private static int[] optimal(int a[], int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        
        for(int i = 0; i < a.length; i++){
            if(map.containsKey(target-a[i])){
                ans[0] = map.get(target-a[i]);
                ans[1] = i;
                return ans;
            }
            map.put(a[i], i);
        }
        return ans;

    }

    public static void main(String args[])
    {
        int a1[] = {3,2,1,5,4};
        int target1 = 3;
        int bruteAns[] = brute(a1, target1);
        System.out.println("Brute - (" + bruteAns[0] + ", " + bruteAns[1] + ")");
        
        int a2[] = {3,2,1,5,4};
        int target2 = 3;
        int betterAns[] = better(a2, target2);
        System.out.println("Better - (" + betterAns[0] + ", " + betterAns[1] + ")");
        
        int a3[] = {3,2,1,5,4};
        int target3 = 3;
        int optimalAns[] = optimal(a3, target3);
        System.out.println("Optimal - (" + optimalAns[0] + ", " + optimalAns[1] + ")");
    }    
}

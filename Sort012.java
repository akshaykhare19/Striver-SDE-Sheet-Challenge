import java.util.Arrays;

public class Sort012
{
    //TC - O(nlogn)
    //SC - O(1)
    public static void bruteApproach(int a[])
    {
        //Sort the array using in-built function
        Arrays.sort(a);
    }

    //TC - O(n)
    //SC - O(1)
    public static void betterApproach(int a[])
    {
        //Count the number of 0s, 1s and 2s in the array and
        //in another pass put that number of 0s, 1s and 2s
        int c0 = 0, c1 = 0, c2 = 0;
        for(int i : a){
            if(i==0) c0++;

            else if(i==1) c1++;

            else c2++;
        }

        for(int i = 0; i < a.length; i++){
            if(c0 > 0){
                a[i] = 0;
                c0--;
            }
            else if(c1 > 0){
                a[i] = 1;
                c1--;
            }
            else{
                a[i] = 2;
                c2--;
            }
        }
    }

    //TC - O(n)
    //SC - O(1)
    public static void optimalApproach(int a[])
    {
        //Using Dutch National Flag Algorithm
        int n = a.length;
        int i = 0, j = 0, k = n-1;
        while(i <= k){
            if(a[i]==0){
                swap(a, i, j);
                i++;
                j++;
            }
            else if(a[i]==1){
                i++;
            }
            else{
                swap(a, i, k);
                k--;
            }
        }
    }

    public static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void display(int a[])
    {
        for(int i : a) 
            System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String args[])
    {
        System.out.println("Brute");
        int a1[] = {0,1,1,1,1,0,1,0,1};
        display(a1);
        bruteApproach(a1);
        display(a1);

        System.out.println("Better");
        int a2[] = {0,1,1,1,2,0,1,0,1};
        display(a2);
        betterApproach(a2);
        display(a2);
        
        System.out.println("Optimal");
        int a3[] = {0,2,1,2,1,0,1,2,1};
        display(a3);
        optimalApproach(a3);
        display(a3);
    }    
}

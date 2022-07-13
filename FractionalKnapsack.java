/*
 * 
Fractional Knapsack
Medium Accuracy: 45.14% Submissions: 84474 Points: 4

Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

 

Example 1:

Input:
N = 3, W = 50
values[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.00
Explanation:Total maximum value of item
we can have is 240.00 from the given
capacity of sack. 

Example 2:

Input:
N = 2, W = 50
values[] = {60,100}
weight[] = {10,20}
Output:
160.00
Explanation:
Total maximum value of item
we can have is 160.00 from the given
capacity of sack.

 

Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size n and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.


Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)
 */

import java.util.*;

public class FractionalKnapsack
{
    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    static class KnapsackComparator implements Comparator<Item>{
        @Override
        public int compare(Item i1, Item i2){
            double r1 = (double)i1.value/(double)i1.weight;
            double r2 = (double)i2.value/(double)i2.weight;
            if(r1 > r2) return -1;
            if(r1 < r2) return 1;
            return 0;
        }
    }
    
    //Function to get the maximum total value in the knapsack.
    private static double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here

        //Sorting the given array on the basis of value/weight in decreasing order
        Arrays.sort(arr, new KnapsackComparator());
        double maxVal = 0.0;
        double currWt = 0.0;
        
        for(Item item : arr){
            double rem = (double)W - currWt;
            if(item.weight <= rem){
                maxVal+=(double)item.value;
                currWt+=item.weight;
            }
            
            else if(item.weight > rem && rem!=0){
                maxVal+=(double)item.value/(double)item.weight*(double)rem;
                currWt+=rem;
                break;
            }
        }
        return maxVal;
    }

    public static void main(String args[])
    {
        int n = 3;
        Item items[] = new Item[n];
        int W = 50;

        items[0] = new Item(60, 10);
        items[1] = new Item(100, 20);
        items[2] = new Item(120, 30);

        System.out.println("Max Value: " + fractionalKnapsack(W, items, n));
    }    
}

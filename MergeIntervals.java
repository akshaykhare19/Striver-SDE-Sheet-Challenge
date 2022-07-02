import java.util.*;

/*
 * Merge Intervals
Medium

Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals, and return an array of the non-overlapping 
intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 

Constraints:

    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104


 */

public class MergeIntervals
{
    private static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length==0 || intervals==null){
            return res.toArray(new int[0][]);
        }
        
        //Sort the intervals array on the basis of start of each interval
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
        
    }

    public static void main(String args[])
    {
        int intervals[][] = {{1,3},{2,6},{8,11},{15,22},{9,10},{12,19}};
        int ans[][] = merge(intervals);

        for(int[] i : ans){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }    
}

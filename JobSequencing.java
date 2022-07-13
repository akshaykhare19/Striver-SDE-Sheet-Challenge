import java.util.Arrays;
/*
 * 
Job Sequencing Problem
Medium Accuracy: 48.94% Submissions: 83286 Points: 4

Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).

Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).


Your Task :
You don't need to read input or print anything. Your task is to complete the function JobScheduling() which takes an integer N and an array of Jobs(Job id, Deadline, Profit) as input and returns the count of jobs and maximum profit.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)


Constraints:
1 <= N <= 105
1 <= Deadline <= 100
1 <= Profit <= 500
 */

public class JobSequencing
{
    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z; 
        }
    }

    // static class JobComparator implements Comparator<Job>
    // {

    //     @Override
    //     public int compare(Job j1, Job j2) {
    //         if(j1.deadline==j2.deadline){
    //             return j2.profit - j1.profit;
    //         }
    //         return j1.deadline - j2.deadline;
    //     }
        
    // }

    private static int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        // JobComparator jc = new JobComparator();
        Arrays.sort(arr, (a,b) -> b.profit-a.profit);
        
        int maxDeadline = 0;
        for(Job j : arr){
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        // System.out.println(maxDeadline);
        int sequence[] = new int[maxDeadline];
        Arrays.fill(sequence, -1);
        int cnt = 0;
        int profit = 0;
        for(int i = 0; i < n; i++){
            Job j = arr[i];
            int idx = j.deadline-1;
            // System.out.println(idx);
            while(idx!=-1 && sequence[idx]!=-1){
                idx--;
            }
            if(idx!=-1){
                sequence[idx] = j.id;
                cnt++;
                profit+=j.profit;
            }
        }
        int ans[] = new int[2];
        for(int i : sequence) System.out.println(i);
        ans[0] = cnt;
        ans[1] = profit;
        return ans;
        
    }

    public static void main(String args[])
    {
        int n = 4;
        Job jobs[] = new Job[n];
        
        jobs[0] = new Job(1,4,20);
        jobs[1] = new Job(2,1,10);
        jobs[2] = new Job(3,1,40);
        jobs[3] = new Job(4,1,30);

        // jobs.forEach(System.out::println);

        for(Job j : jobs)
        {
            System.out.println("Id - "+j.id + "; Deadline - " +j.deadline+"; Profit - " + j.profit);
        }

        int maxProfit[] = JobScheduling(jobs, n);
        System.out.println("No. of Jobs: " + maxProfit[0] + "; Max Profit: " + maxProfit[1]);

    }
}

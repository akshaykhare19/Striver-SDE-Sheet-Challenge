/*
 * DFS of Graph
EasyAccuracy: 49.62%Submissions: 100k+Points: 2
Lamp
This problem is part of GFG SDE Sheet. Click here to view more.  

Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph..


Example 1:

Input:

Output: 0 1 2 4 3
Explanation: 
0 is connected to 1, 2, 4.
1 is connected to 0.
2 is connected to 0.
3 is connected to 4.
4 is connected to 0, 3.
so starting from 0, it will go to 1 then 2
then 4, and then from 4 to 3.
Thus dfs will be 0 1 2 4 3.

Example 2:

Input:

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 


Your task:
You dont need to read input or print anything. Your task is to complete the function dfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns  a list containing the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 104

 */

import java.util.*;
public class DfsTraversal
{
    private static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        ans.add(node);
        visited[node] = true;
        for(int it : adj.get(node)){
            if(!visited[it]){
                dfs(it, visited, adj, ans);
            }
        }
    }
    
    
    // Function to return a list containing the DFS traversal of the= graph.
    private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, visited, adj, ans);
            }
        }
        return ans;
    }

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        System.out.println(dfsOfGraph(5, adj));

    }

}
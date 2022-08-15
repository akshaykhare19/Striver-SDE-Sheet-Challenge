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
    
    
    // Function to return a list containing the DFS traversal of the graph.
    private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
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
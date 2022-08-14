import java.util.*;

public class Bfs
{
    // Function to return Breadth First Traversal of given graph.
    private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
            q.add(0);
            visited[0] = true;
            while(!q.isEmpty()){
                int rem = q.poll();
                ans.add(rem);
                for(int j = 0; j < adj.get(rem).size(); j++){
                    if(!visited[adj.get(rem).get(j)]){
                        q.add(adj.get(rem).get(j));
                        visited[adj.get(rem).get(j)] = true;
                    }
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

        System.out.println(bfsOfGraph(5, adj));

    }

}
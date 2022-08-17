import java.util.*;

public class Heap
{
    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.
    static void swap(ArrayList<Integer> heap, int i, int j){
        int t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }
    
    private static void insert(ArrayList<Integer> heap, int x){
        heap.add(x);
        int child = heap.size()-1;
        while(child>0){
            int parent = (child-1)/2;
            if(heap.get(parent) > heap.get(child)){
                swap(heap, parent, child);
                child = parent;
            }
            else return;
        }
    }
    
    private static int delete(ArrayList<Integer> heap){
        int min = heap.get(0);
        swap(heap, 0, heap.size()-1);
        heap.set(heap.size()-1, null);
        
        int parent = 0;
        int n = heap.size();
        while(parent < n){
            int left = parent*2 + 1;
            int right = parent*2 + 2;
            int leftChild = Integer.MAX_VALUE, rightChild = Integer.MAX_VALUE;
            if(left<n){
                leftChild = heap.get(left);
            }
            if(right<n){
                rightChild = heap.get(right);
            }
            
            int smaller = leftChild >= rightChild ? right : left;
            
            if(heap.get(parent) > heap.get(smaller)){
                swap(heap, parent, smaller);
                parent = smaller;
            }
            else break;
        }
        
        return min;
    }
    
    private static ArrayList<Integer> minHeap(int n, int[][] q) {
        // Write your code here.
        ArrayList<Integer> heap = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(q[i][0]==0){
                insert(heap, q[i][1]);
            }
            else if(q[i][0]==1){
                System.out.print(delete(heap));
            }
        }
        return heap;
    }

    public static void main(String args[])
    {
        int n = 3;
        int q[][] = {{0,2}, {0,1}, {1}};
        System.out.println(minHeap(n, q));

    }
}
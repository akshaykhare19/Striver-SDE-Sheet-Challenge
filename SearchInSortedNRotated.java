//Search an element in rotated and sorted array

public class SearchInSortedNRotated 
{
    //TC - O(log n)
    //SC - O(1)
    public static int rotatedSearch(int a[], int key, int low, int high)
    {
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(a[mid] == key) return mid;

            //checks if the left part of the array is sorted or not
            if(a[low] <= a[mid])
            {
                //checks if the key element is present in the left part or not
                if(key >= a[low] && key < a[mid])
                {
                    //discards the right part of the array
                    high = mid-1;
                }
                else{
                    //discards the left part of the array
                    low = mid+1;
                }
            }
            else{
                //checks if the key element is present in the left part or not
                if(key > a[mid] && key <= a[high])
                {
                    //discards the left part of the array
                    low = mid+1;
                }
                else{
                    //discards the right part of the array
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int a[] = {3,1};
        int key = 1;
        System.out.println(rotatedSearch(a, key, 0, a.length-1));
    }
}

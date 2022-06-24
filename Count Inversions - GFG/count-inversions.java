// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    


static long inversionCount(long arr[], long N)
   {
       // Your Code Here
       return mergeSortAndCount(arr,0,N-1);
   }
   
   private static long mergeAndCount(long[] arr, long l,
                                    long m, long r)
   {

       long[] left = Arrays.copyOfRange(arr,(int) l, (int)(m + 1));
       long[] right = Arrays.copyOfRange(arr,(int)(m + 1),(int)( r + 1));

       long i = 0, j = 0, k = l, swaps = 0;

       while (i < left.length && j < right.length) {
           if (left[(int)i] <= right[(int)j])
               arr[(int)k++] = left[(int)i++];
           else {
               arr[(int)k++] = right[(int)j++];
               swaps += (m + 1) - (l + i);
           }
       }
       while (i < left.length)
           arr[(int)k++] = left[(int)i++];
       while (j < right.length)
           arr[(int)k++] = right[(int)j++];
       return swaps;
   }
   private static long mergeSortAndCount(long[] arr, long l,
                                        long r)
   {
       long coun = 0;

       if (l < r) {
           long m = (l + r) / 2;
           coun += mergeSortAndCount(arr, l, m);
           coun += mergeSortAndCount(arr, m + 1, r);
           coun += mergeAndCount(arr, l, m, r);
       }

       return coun;
   }
}
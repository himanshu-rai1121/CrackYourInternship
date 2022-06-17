// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        
        int arr2[] = new int[n];
        for(int i = 0; i < arr.length; i++)
        {
            arr2[i] = 0;
        }
        int q=0;
        for(int i=0;i<n;i++)
        {
            q=arr[i];
            arr2[q]++;
        }
        int p=0,count=0;
        
        for(int i=0;i<n;i++)
        {
            if(arr2[i]>1)
            {
                count++;
            }
            
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        if(count>0)
        {
            int arr3[] = new int[count];
            // arr3[0]=-1;
        
        for(int i=0;i<n;i++)
        {
            if(arr2[i]>1)
            {
                arr3[p]=i;
                p++;
            }
            
        }
         
         for(int i=0;i<p;i++)
         {
             list2.add(arr3[i]);
         }
        }
         if(count==0)
         list2.add(-1);
        return list2;
        
        
    }
}

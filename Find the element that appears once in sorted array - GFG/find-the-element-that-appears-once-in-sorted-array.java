//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        int l = 0, r = n-1;
        
        while(l<r)
        {
            int mid = (l+r)/2;
            if(mid!=0 && mid!=n-1 &&arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1])
                return arr[mid];
            if(mid%2==0)
                if(arr[mid]==arr[mid+1])
                    l=mid+1;
                else
                    r=mid-1;
            else
                if(arr[mid-1]==arr[mid])
                    l=mid+1;
                else
                    r=mid-1;
        }
        return arr[l];
    }
}
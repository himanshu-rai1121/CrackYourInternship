//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int startInd(int[] nums)
    {
        int start = 0;
        int end = nums.length-1;
        int mid = start + ((end-start)/2);
        if(nums[0]<nums[end])
            return 0;
        while(start<end)
        {
            if(nums[mid]>=nums[0])
                start=mid+1;
            else
                end = mid;
            mid = start + ((end-start)/2);
        }
        return start;//we can return both start and end
    }
    
    int binSearch(int[] nums, int target, int start, int end)
    {
        int mid = start+((end-start)/2);
        while(start<=end)
        {
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                end = mid-1;
            else
                start = mid+1;
            mid = start+((end-start)/2);
        }
        return -1;
    }
    
    int search(int nums[], int l, int h, int target)
    {
        int minindex = startInd(nums);
        int end = nums.length-1;
        if(target>nums[end])//first half
        {
            return binSearch(nums, target, 0, minindex-1);
        }
        else//second half
        {
            return binSearch(nums, target, minindex, end);
        }
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    // static  int pp = 0;
    static int solve(int n, int[] arr, int target, int index, int[][] dp)
    {
            if(index>=n)
                return 0;
            if(target<0)
                return 0;
            if(target == 0)
                return 1;
            
            if(dp[index][target]!=-1)
                return dp[index][target];
            int incl = solve(n, arr, target-arr[index], index+1,dp);
            int excl = solve(n, arr, target, index+1,dp);
            return dp[index][target]=incl|excl;
            
    }
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int i=0;i<N;i++)
            sum+=arr[i];
        if(sum%2!=0)
            return 0;
    
        int[][] dp = new int[N][sum/2+1];
        for(int i=0;i<N;i++)
            for(int j=0;j<sum/2+1;j++)
                dp[i][j] = -1;
        return solve(N, arr, sum/2,0, dp);
        // return pp;
    }
}
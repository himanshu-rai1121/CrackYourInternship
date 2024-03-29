//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // int solve(int n)
    // {
    //     if(n==0)
    //         return 0;
            
    //     int ans = n;
    //     for(int i=1;i*i<=n;i++)
    //     {
    //         ans = Math.min(ans, 1+solve(n-(i*i)) );
    //     }
    //     return ans;
    // }
    
    int solvedp(int n, int[] dp)
    {
        if(n==0)
            return 0;
        
        if(dp[n]!=-1)
            return dp[n];
        int ans = n;
        for(int i=1;i*i<=n;i++)
        { 
            int temp = i*i;
            ans = Math.min(ans, 1+solvedp(n-temp, dp) );
        }
        dp[n] = ans;
        return ans;
    }
    
    int solvetab(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j*j<=n;j++)
            {
                int temp = j*j;
                if(i-temp>=0)
                    dp[i] = Math.min(dp[i], 1+dp[i-temp] );
            }
        }
        return dp[n];
    }
    
    public int MinSquares(int n)
    {
        // Code here
        // return solve(n);
        
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return solvedp(n, dp);
        
        return solvetab(n);
    }
}
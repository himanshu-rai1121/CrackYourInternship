//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M,N,X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // static long solve(int dice, int faces, int target)
    // {
    //     if(target<0)
    //         return 0;
    //     if(dice==0 && target!=0)
    //         return 0;
    //     if(target==0 && dice!=0)
    //         return 0;
    //     if(target==0 && dice==0)
    //         return 1;
            
    //     long ans = 0;
    //     for(int i=1;i<=faces;i++)
    //     {
    //         ans+=solve(dice-1, faces, target-i);
    //     }
    //     return ans;
    // }
    
    static long solvedp(int dice, int faces, int target, long[][] dp)
    {
        if(target<0)
            return 0;
        if(dice==0 && target!=0)
            return 0;
        if(target==0 && dice!=0)
            return 0;
        if(target==0 && dice==0)
            return 1;
           
        if(dp[dice][target]!=-1)
            return dp[dice][target];
        long ans = 0;
        for(int i=1;i<=faces;i++)
        {
            ans+=solvedp(dice-1, faces, target-i, dp);
        }
        dp[dice][target] = ans;
        return dp[dice][target];
    }
    
    static long noOfWays(int M , int N , int X) {
        // return solve(N, M, X);
        
        long[][] dp =new long[N+1][X+1];
        for(int i=0;i<=N;i++)
            Arrays.fill(dp[i], -1L);
        return solvedp(N, M, X, dp);
    }
};
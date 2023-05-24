//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int result = 0;
    // static int solve(int n, int m, int mat[][], int i, int j)
    // {
    //     if(i>=n || j>=m)
    //         return 0;
    //     int right = solve(n, m, mat, i, j+1);
    //     int diagonal = solve(n, m, mat, i+1, j+1);
    //     int bottom = solve(n, m, mat, i+1, j);
        
    //     if(mat[i][j]==1)
    //     {
    //         int ans = 1 + (Math.min(Math.min(right, diagonal), bottom));
    //         result = Math.max(result, ans);
    //         return ans;
    //     }
    //     else
    //     {
    //         return 0;
    //     }
    // }
    
    static int solvedp(int n, int m, int mat[][], int i, int j, int[][] dp)
    {
        if(i>=n || j>=m)
            return 0;
        int right = solvedp(n, m, mat, i, j+1, dp);
        int diagonal = solvedp(n, m, mat, i+1, j+1, dp);
        int bottom = solvedp(n, m, mat, i+1, j, dp);
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(mat[i][j]==1)
        {
            dp[i][j] = 1 + (Math.min(Math.min(right, diagonal), bottom));
            result = Math.max(result, dp[i][j]);
            return dp[i][j];
        }
        else
        {
            return dp[i][j] = 0;
        }
    }
    
    static int solvetab(int[][] mat)
    {
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] dp = new int[row+1][col+1];
        
        // base case already initialilzed with 0
        
        for(int i=row-1;i>=0;i--)
        {
            for(int j=col-1;j>=0;j--)
            {
                int right = dp[i][j+1];
                int diagonal = dp[i+1][j+1];
                int bottom = dp[i+1][j];
                
                if(mat[i][j]==1)
                {
                    dp[i][j] = 1 + (Math.min(Math.min(right, diagonal), bottom));
                    result = Math.max(result, dp[i][j]);
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0];
    }
    
    static int maxSquare(int n, int m, int mat[][]){
        // result = 0;
        // solve(n, m, mat, 0, 0);
        // return result;
        
        // int[][] dp = new int[n][m];
        // for(int i=0;i<n;i++)
        //     Arrays.fill(dp[i], -1);
        // result = 0;
        // solvedp(n, m, mat, 0, 0, dp);
        // return result;
        
        result = 0;
        solvetab(mat);
        return result;
        
        
        
    }
}
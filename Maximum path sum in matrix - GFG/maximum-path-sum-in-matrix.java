//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        return solvetab(Matrix);
    }
    static int solvetab(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]dp = new int[n][m];
        for(int i=0;i<m;i++)
            dp[n-1][i] = matrix[n-1][i];
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<m;j++)
            {
                int left = Integer.MIN_VALUE;int down = Integer.MIN_VALUE;int right = Integer.MIN_VALUE;
                if(j>0)
                    left = matrix[i][j] + dp[i+1][j-1];
                if(j<m-1)
                    right = matrix[i][j] + dp[i+1][j+1];
                down = matrix[i][j] + dp[i+1][j];
                dp[i][j] = Math.max(left, Math.max(down, right));

            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            ans = Math.max(ans, dp[0][i]);
        }
        return ans;
    }
    // int solve(int row, int col, int n, int m, int[][] matrix, int[][]dp)
    // {
    //     if(col<0 || col>=m)
    //         return (int)1e9;
    //     if(row==n-1)
    //         return matrix[row][col];
    //     if(dp[row][col]!=-1)
    //         return dp[row][col];

    //     int left = matrix[row][col] + solve(row+1, col-1, n, m, matrix, dp);
    //     int down = matrix[row][col] + solve(row+1, col, n, m, matrix, dp);
    //     int right = matrix[row][col] + solve(row+1, col+1, n, m, matrix, dp);

    //     return dp[row][col] = Math.min(left, Math.min(down, right));
    // }
}
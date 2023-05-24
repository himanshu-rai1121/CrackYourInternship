class Solution {

    // int solve(int[] values, int i, int j)
    // {
    //     if(i+1==j)
    //         return 0;
    //     int ans = Integer.MAX_VALUE;
    //     for(int k=i+1;k<j;k++)
    //     {
    //         ans = Math.min(ans, values[i]*values[k]*values[j] + solve(values, i, k) + solve(values, k, j));
    //     }
    //     return ans;
    // }
    
    // int solvedp(int[] values, int i, int j, int[][] dp)
    // {
    //     if(i+1==j)
    //         return 0;
    //     int ans = Integer.MAX_VALUE;
    //     if(dp[i][j]!=-1)
    //         return dp[i][j];
    //     for(int k=i+1;k<j;k++)
    //     {
    //         ans = Math.min(ans, values[i]*values[k]*values[j] + solvedp(values, i, k, dp) + solvedp(values, k, j, dp));
    //     }
    //     dp[i][j] = ans;
    //     return dp[i][j];
    // }
    
    int solvetab(int[] values)
    {
        int n = values.length;
        int[][] dp = new int[n][n];
        
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i+2;j<n;j++)
            {
                int ans = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++)
                {
                    ans = Math.min(ans, values[i]*values[k]*values[j] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];
    }
    public int minScoreTriangulation(int[] values) {
        // return solve(values, 0, values.length-1);
        
        // int[][] dp = new int[values.length][values.length];
        // for(int i=0;i<values.length;i++)
        //     Arrays.fill(dp[i], -1);
        // return solvedp(values, 0, values.length-1, dp);
        
        return solvetab(values);
    }
}
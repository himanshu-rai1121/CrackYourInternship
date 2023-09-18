//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >triangle) {
        // Code here
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        return solve(0, 0, triangle, dp);
    }
    static int solve(int row, int i, ArrayList<ArrayList<Integer>> triangle, int[][]dp)
    {
        if(row==triangle.size()-1)
            return triangle.get(row).get(i);
        if(dp[row][i]!=-1)
            return dp[row][i];
        int same = triangle.get(row).get(i) + solve(row+1, i, triangle, dp);
        int increase = triangle.get(row).get(i) + solve(row+1, i+1, triangle, dp);
        return dp[row][i] = Math.min(same, increase);
        
    }
}
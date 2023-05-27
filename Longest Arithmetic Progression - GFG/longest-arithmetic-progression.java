//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    // int solve(int[] A, int index, int diff)
    // {
    //     if(index<0)
    //         return 0;
            
    //     int ans = 0;
    //     for(int j=index-1;j>=0;j--)
    //     {
    //         if(A[index]-A[j]==diff)
    //             ans = Math.max(ans, 1 + solve(A, j, diff));
    //     }
    //     return ans;
    // }
    
    int solve(int[] A, int index, int diff, HashMap<Integer, HashMap<Integer, Integer>> dp)
    {
        if(index<0)
            return 0;
        if(dp.containsKey(index) && dp.get(index).containsKey(diff))
            return dp.get(index).get(diff);
        int ans = 0;
        for(int j=index-1;j>=0;j--)
        {
            if(A[index]-A[j]==diff)
                ans = Math.max(ans, 1 + solve(A, j, diff, dp));
        }
        if(!dp.containsKey(index))
        {
            dp.put(index, new HashMap<>());
        }
        dp.get(index).put(diff, ans);
        return dp.get(index).get(diff);
    }
    
    int lengthOfLongestAP(int[] A, int n) {
        // code here
        if(n<=2)
            return n;
            
        HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();
        // for(int i=0;i<n+1;i++)
        //     mp.put(i,i);
            
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                ans = Math.max(ans, 2 + solve(A, i, A[j]-A[i], dp));
            }
        }
        return ans;
    }
}

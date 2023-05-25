//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    
    // static int solve(int size, int[] a, int curr, int prev)
    // {
    //     if(size==curr)
    //         return 0;
            
    //     int incl = 0;
    //     if(prev==-1 || a[curr]>a[prev])
    //         incl = 1 + solve(size, a, curr+1, curr);
        
    //     int excl = 0 + solve(size, a, curr+1, prev);
        
    //     return Math.max(incl, excl);
    // }
    
    // static int solvedp(int size, int[] a, int curr, int prev, int[][]dp)
    // {
    //     if(size==curr)
    //         return 0;
        
    //     if(dp[curr][prev+1]!=-1)
    //         return dp[curr][prev+1];
            
    //     int incl = 0;
    //     if(prev==-1 || a[curr]>a[prev])
    //         incl = 1 + solvedp(size, a, curr+1, curr, dp);
        
    //     int excl = 0 + solvedp(size, a, curr+1, prev, dp);
        
        
    //     return dp[curr][prev+1] = Math.max(incl, excl);
    // }
    
    // static int solvetab(int size, int[] a)
    // {
    //     int [][] dp = new int[size+1][size+1]; 
        
    //     for(int curr = size-1;curr>=0;curr--)
    //     {
    //         for(int prev = curr-1;prev>=-1;prev--)
    //         {
    //             int incl = 0;
    //             if(prev==-1 || a[curr]>a[prev])
    //                 incl = 1 + dp[curr+1][curr+1];
                
    //             int excl = 0 + dp[curr+1][prev+1];
                
                
    //             dp[curr][prev+1] = Math.max(incl, excl);
    //         }
    //     }
    //     return dp[0][0];
        
    // }
    
    
    static int solveBinary(int n, int[] a)
    {
        if(n==0)
            return 0;
            
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a[0]);
        
        for(int i=1;i<n;i++)
        {
            int len = ans.size();
            if(a[i]>ans.get(len-1))
            {
                ans.add(a[i]);
            }
            else
            {
                // find index of just greater element
                int index = Collections.binarySearch(ans, a[i]);
                if (index < 0)
                    index = -(index + 1);
                ans.set(index, a[i]);
            }
        }
        return ans.size();
    }
    
    
    
    static int longestSubsequence(int size, int a[])
    {
        // return solve(size, a, 0, -1);
        
        // int [][] dp = new int[size][size+1];
        // for(int i=0;i<size;i++)
        //     Arrays.fill(dp[i], -1);
        // return solvedp(size, a, 0, -1, dp);
        
        // return solvetab(size, a);
        
        return solveBinary(size, a);
    }
} 
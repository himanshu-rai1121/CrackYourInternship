//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    // static int solve(String text1, int i, String text2, int j)
    // {
    //     if(text1.length()<=i || text2.length()<=j)
    //         return 0;
    //     if(text1.charAt(i)==text2.charAt(j))
    //         return 1+solve(text1, i+1, text2, j+1);
    //     else
    //     {
    //         return Math.max( solve(text1, i+1, text2, j), solve(text1, i, text2, j+1) );
    //     }
    // }

    // static int solvedp(String text1, int i, String text2, int j, int[][] dp)
    // {
    //     if(text1.length()<=i || text2.length()<=j)
    //         return 0;

    //     if(dp[i][j]!=-1)
    //         return dp[i][j];
    //     int ans = 0;
    //     if(text1.charAt(i)==text2.charAt(j))
    //         ans =  1+solvedp(text1, i+1, text2, j+1, dp);
    //     else
    //     {
    //         ans = Math.max( solvedp(text1, i+1, text2, j, dp), solvedp(text1, i, text2, j+1, dp) );
    //     }
    //     return dp[i][j] = ans;
    // }
    
    static int solvetab(String text1, String text2)
    {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i=text1.length()-1;i>=0;i--)
        {
            for(int j=text2.length()-1;j>=0;j--)
            {
                int ans = 0;
                if(text1.charAt(i)==text2.charAt(j))
                    ans =  1+dp[i+1][j+1];
                else
                {
                    ans = Math.max( dp[i+1][j], dp[i][j+1]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
    
    
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // return solve(text1, 0, text2, 0);

        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int i=0;i<s1.length();i++)
        //     Arrays.fill(dp[i], -1);
        // return solvedp(s1, 0, s2, 0, dp);
        
        
        return solvetab(s1, s2);

    }
    
}
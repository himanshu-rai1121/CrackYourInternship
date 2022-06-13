// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


class Solution
{
   String longestCommonPrefix(String arr[], int n){
       // code here
       if(arr==null || arr.length==0)
       {
           return "-1";
       }
       String lcp = arr[0];
       for(int i=1; i<arr.length; i++)
       {
           String currentWord = arr[i]; 
           int j =0;
           while(j<currentWord.length()&&j<lcp.length()&&currentWord.charAt(j)==lcp.charAt(j))
           {
               j++;
           }
           if(j==0)
           {
               return "-1";
           }
           lcp = currentWord.substring(0,j);
       }
       return lcp;
       
   }
}
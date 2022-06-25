// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String S) {
        // code here
        
        Set<String> se = new LinkedHashSet<String>();
        
        for(int i=0;i<S.length();i++)
        {
            se.add(S.substring(i,i+1));
        }
        String[] Geeks = se.toArray(new String[se.size()]);
        String st="";
        for(int i=0;i<se.size();i++)
        {
            st=st+Geeks[i];
        }
        return st;
        
    }
}
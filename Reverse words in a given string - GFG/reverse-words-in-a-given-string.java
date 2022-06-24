// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here
        
        int p=S.length();
        String sub="";
        String ans="";
        int pos=p;
        for(int i=p-1;i>=0;i--)
        {
            if(S.charAt(i)=='.')
            {
                sub=S.substring(i+1,pos);
                pos=i;
                ans=ans+sub;
                ans=ans+".";
            }
        }
        sub=S.substring(0,pos);
        ans=ans+sub;
        
        return ans;
        
        
    }
}
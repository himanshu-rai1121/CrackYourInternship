// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        
        //while testcases exist
        while(t-->0){
            
            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);
            
            ArrayList<Integer> arr = new ArrayList<>();            
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }
            
            Solution obj = new Solution();
            obj.reverseInGroups(arr, n, k);
            
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends




class Solution {

   //Function to reverse every sub-array group of size k.
   void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
       // code here
       ArrayList<Integer> a=new ArrayList<>();
       int kl=k;
       if(k>=n){
           for(int i=n-1;i>=0;i--)
           a.add(arr.get(i));
       }
       else{
       for(int i=0;i<n;i+=kl){
           for(int j=k-1;j>=i;j--){
               a.add(arr.get(j));
           }
           k+=kl;
           if(k>=n){
               k=n;
           }
           
           
           
       }}
       arr.clear();
       for(int i=0;i<n;i++){
           arr.add(a.get(i));
       }
   }}

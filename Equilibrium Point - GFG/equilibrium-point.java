// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}// } Driver Code Ends


class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
   public static int equilibriumPoint(long a[], int n) {

       // Your code here
        if(n==1)return 1;
       
       int i=0,j=n-1,k=0;
       long s1=a[0],s2=a[n-1];
       
       while(i<j){
           
          if( s1 < s2 ){
              i++;
              s1 += a[i];
          }else{
              j--;
              s2 += a[j];
          }
          
          
           
       }
       if(  s1 == s2 )
           return i+1;
       return -1;
   }

        
    }


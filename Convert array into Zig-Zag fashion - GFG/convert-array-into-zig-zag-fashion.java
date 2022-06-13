// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().zigZag(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution {
    void zigZag(int arr[], int n) {
        // code here
        int swap=0;
        for(int i=0;i<n-1;i++)
        {
            if(i%2==0)//i=0,2,4,8....   A[i]<A[i+1]
            {
                if(arr[i]>arr[i+1])
                {
                    swap=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=swap;
                }
            }
            else
            {
                if(arr[i]<arr[i+1])
                {
                    swap=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=swap;
                }
            }
        }
        // return arr;
        
    }

}
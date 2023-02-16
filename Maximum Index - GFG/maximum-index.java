//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    static int maxIndexDiff(int A[], int N) { 
        
        // Your code here
        int left[]=new int[N];
        int right[]=new int[N];
        int max=A[N-1],min=A[0];
        for(int i=0;i<N;i++)
        {
            min=Math.min(min,A[i]);
            left[i]=min;
        }
        
         for(int i=N-1;i>=0;i--)
        {
            max=Math.max(max,A[i]);
            right[i]=max;
        }
        int i=0,j=0,ans=0;
        while(i<N && j<N)
        {
            if(left[i]<=right[j])
            {
                ans=Math.max(ans,j-i);
                j++;
            }
            else
            i++;
        }
        return ans;
        
    }

    
    // static int maxIndexDiff(int A[], int N) { 
        
    //     int[] left_min = new int[N];
    //     int[] right_mx = new int[N];
        
    //     int max=A[N-1],min=A[0];
    //     for(int i=0;i<N;i++)
    //     {
    //         min=Math.min(min,A[i]);
    //         left_min[i]=min;
    //     }
    //     for(int i=0;i<N;i++)
    //     {
    //         max=Math.max(max,A[i]);
    //         right_mx[i]=max;
    //     }
    //     int i=0,j=0,ans = 0;
    //     while(i<N&&j<N)
    //     {
    //         if(right_mx[j]>=left_min[i])
    //         {
    //             ans = Math.max(ans, j-i);
    //             j++;
    //         }
    //         else
    //             i++;
    //     }
    //     return ans;
    // }
}



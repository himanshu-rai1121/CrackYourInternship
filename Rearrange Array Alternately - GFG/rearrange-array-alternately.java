// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}



// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // Your code here
        long[] arr1 = new long[(n/2)+1];  //big
        long[] arr2 = new long[(n/2)+1];  //small
        
        Arrays.sort(arr);
        int p=n-1;
        for(int i=0;i<=n/2;i++)
        {
            arr1[i]=arr[p];
            p--;
        }
        for(int i=0;i<n/2;i++)
        {
            arr2[i]=arr[i];
        }
        int q=0;
        p=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                arr[i]=arr1[p];
                p++;
            }
            else
            {
                arr[i]=arr2[q];
                q++;
            }
        }
        
    }
    
}



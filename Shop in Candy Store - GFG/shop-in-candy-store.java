//{ Driver Code Starts
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
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int k){
        // code here
        Arrays.sort(candies);
        int min = 0, max =0;
        int n = N;
        for(int i=0;i<n;i++)
        {
            min+=candies[i];
            n-=k;
        }
        n=N;
        int p = 0;
        for(int i=n-1;i>=p;i--)
        {
            max+=candies[i];
            p+=k;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(max);
        return result;
    }
}
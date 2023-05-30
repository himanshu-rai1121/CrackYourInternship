//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        // code here
        
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++)
        {
            arr[i][0] = i+1;
            arr[i][1] = start[i];
            arr[i][2] = end[i];

        }
        Arrays.sort(arr, (a, b)->(Integer.compare(a[2], b[2])));
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0][0]);
        int prevend = arr[0][2];
        for(int i=1;i<n;i++)
        {
            // System.out.print(arr[i][1]+" ");
            if(prevend<arr[i][1])
            {
                prevend = arr[i][2];
                result.add(arr[i][0]);
            }
        }
        // System.out.println();
        Collections.sort(result);
        return result;
        
        
    }
}
        

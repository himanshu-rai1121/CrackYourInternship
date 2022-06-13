// { Driver Code Starts
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
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] a = IntArray.input(br, n);
            
            Solution obj = new Solution();
            obj.convertToWave(n, a);
            StringBuffer sb=new StringBuffer("");
            for(int i : a){
                sb.append(i+" ");
            }
            System.out.println(sb.toString());
        }
    }
}
// } Driver Code Ends


class Solution {
    public static void convertToWave(int n, int[] a) {
        // code here
        int swap=0;
        for(int i=0;i<n-1;i++)
        {
            if(i%2==0)//i=0,2,4,8....   A[i]<A[i+1]
            {
                if(a[i]<a[i+1])
                {
                    swap=a[i];
                    a[i]=a[i+1];
                    a[i+1]=swap;
                }
            }
            else
            {
                if(a[i]>a[i+1])
                {
                    swap=a[i];
                    a[i]=a[i+1];
                    a[i+1]=swap;
                }
            }
        }
    }
}
        

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        int temp1=0,temp2=0;
        for(int j=0;j<Intervals.length-1;j++)
        {
            for(int i=0;i<Intervals.length-1-j;i++)
            {
                if(Intervals[i][0]>Intervals[i+1][0])
                {
                    temp1=Intervals[i][0];
                    temp2=Intervals[i][1];
                    Intervals[i][0]=Intervals[i+1][0];
                    Intervals[i][1]=Intervals[i+1][1];
                    Intervals[i+1][0]=temp1;
                    Intervals[i+1][1]=temp2;
                }
            }
        }
        int count=1;
        int p=0,max=Intervals[0][1];
        for(int i=1;i<Intervals.length;i++)
        {
            if(max<Intervals[i][0])
            {
                count++;
                max=Intervals[i][1];
            }
            else if(max<Intervals[i][1])
            {
                max=Intervals[i][1];
            }
        }
        
        int[][] arr = new int[count][2];
        arr[0][0]=Intervals[0][0];
        p=0;max=Intervals[0][1];
        
        for(int i=1;i<Intervals.length;i++)
        {
            if(max<Intervals[i][0])
            {//push i1 and i+1 0 both
                arr[p][1]=max;
                arr[p+1][0]=Intervals[i][0];
                p++;
                max=Intervals[i][1];
            }
            else if(max<Intervals[i][1])
            {
                max=Intervals[i][1];
            }
            //else skip to the next
        }
        arr[p][1]=max;
        
        
        
        return arr;
        
        
        
    }
}
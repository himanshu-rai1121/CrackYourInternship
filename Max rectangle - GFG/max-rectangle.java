//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[]  left_smallest  = new int[n];
        int [] right_smallest = new int[n];
        Stack<Integer> lt = new Stack<>();
        Stack<Integer> rt = new Stack<>();

        
        for(int i=0;i<n;i++)
        {
            if(lt.isEmpty())
                left_smallest[i]=-1;

            else{
                while(!lt.isEmpty() && heights[lt.peek()]>=heights[i] )
                    lt.pop();
                if(!lt.isEmpty())
                    left_smallest[i]=lt.peek();
                else
                    left_smallest[i]=-1;
            }
            lt.push(i);
        }
        for(int i=n-1;i>=0;i--)
        {
            if(rt.isEmpty())
                right_smallest[i]=n;
            else{
                while(!rt.isEmpty() && heights[rt.peek()]>=heights[i])
                    rt.pop();
                if(!rt.isEmpty())
                    right_smallest[i]=rt.peek();
                else
                    right_smallest[i]=n;
            }
            rt.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++)
        {
            max=Math.max( (right_smallest[i]-(left_smallest[i]+1)) * heights[i] , max );
        }
        // System.out.println(max);
        return max;
    }
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        
        int[] height = new int[m];
        int max = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(M[i][j]==1)
                    height[j]++;
                else
                    height[j]=0;
            }
            max = Math.max(largestRectangleArea(height), max);
        }
        return max;
    }
}
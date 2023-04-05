//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class node
{
	int data;
	int i;
	int j;
	public node(int data, int i, int j)
	{
		this.data = data;
		this.i = i;
		this.j = j;
	}
}
class Solution 
{
	public static ArrayList<Integer> mergeKArrays(int[][] arr, int k)
	{
		// Write your code here.
		PriorityQueue<node> pq = new PriorityQueue<>((a,b)->{return a.data-b.data;});
		ArrayList<Integer> ans = new ArrayList<>();

		for(int i=0;i<arr.length;i++)
		{
			node n = new node(arr[i][0], i, 0);
			pq.add(n);
		}
		while(!pq.isEmpty())
		{
			node n = pq.poll();
			ans.add(n.data);
			int i=n.i;
			int j= n.j;
			if(j+1<arr[i].length)
			{
				node nn = new node(arr[i][j+1], i, j+1);
				pq.add(nn);
			}
		}
		return ans;

	}
}

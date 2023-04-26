//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int i, int j)
    {
        this.first = i;
        this.second = j;
    } 
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean check_bfs(int node,int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis)
    {
        vis[node] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        while(!q.isEmpty())
        {
            int no = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(int adjacentNode : adj.get(no))
            {
                if(vis[adjacentNode]==false)
                {
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, no));
                }
                else if(parent!=adjacentNode)
                    return true;
            }
        }
        return false;
    }
    
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        
        for(int i=0;i<V;i++)
            vis[i]=false;
        
        for(int i=0;i<V;i++)
            if(vis[i]==false)
                if(check_bfs(i, V, adj, vis))
                    return true;
        return false;
    }
}
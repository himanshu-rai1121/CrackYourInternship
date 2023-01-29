//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    ArrayList<Integer> left(Node root,ArrayList<Integer> lst)
    {
        
        if(root==null || (root.left==null&&root.right==null))
            return lst;
        lst.add(root.data);
        if(root.left!=null)
            lst = left(root.left,lst);
        else
            lst=left(root.right,lst);
        return lst;
    }
    ArrayList<Integer> right(Node root,ArrayList<Integer> lst)
    {
        
        if(root==null || (root.left==null&&root.right==null))
            return lst;
        lst.add(root.data);
        if(root.right!=null)
        lst = right(root.right,lst);
        else
            lst=right(root.left,lst);
        return lst;
    }
    ArrayList<Integer> leafNode(Node root,ArrayList<Integer> lst)
    {
        
        if(root==null)
            return lst;
        if(root.left==null && root.right==null)
        {
            lst.add(root.data);
            return lst;
        }
        lst = leafNode(root.left,lst);
        
        lst = leafNode(root.right,lst);
        return lst;
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> lst = new ArrayList<>();
	    if(node !=null)
	        lst.add(node.data);
	    lst = left(node.left,lst);
	    ArrayList<Integer> rst = new ArrayList<>();
	    if(node!=null)
	        rst = right(node.right,rst);
        Collections.reverse(rst);
	   // return rst;
	   
	   ArrayList<Integer> leaf = new ArrayList<>();
	   leaf = leafNode(node.left,leaf);
	   leaf = leafNode(node.right,leaf);
	   //return leaf;
	   lst.addAll(leaf);
	   lst.addAll(rst);
	   return lst;
	   
	}
}

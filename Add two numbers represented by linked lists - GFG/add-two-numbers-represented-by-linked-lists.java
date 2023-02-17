//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node root)
    {
        Node curr = root;
        Node prev = null;
        Node next = null;
        if(root!=null)
        next = root.next;
        while(curr!=null)
        {
            curr.next = prev;
            prev = curr;
            curr=next;
            if(curr!=null)
                next=next.next;
        }
        return prev;
    }
    
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        
        first = reverse(first);
        second = reverse(second);
        // return second;
        
        int rem = 0;
        Node ans =new Node(0);
        Node as = ans;
        while(first!=null || second!=null || rem!=0 )
        {
            
            int f = first!=null ? first.data : 0;
            int s = second!=null ? second.data : 0;
            int i = f+s+rem;
            rem = i/10;
            i=i%10;
            Node temp = new Node(i);
            ans.next = temp;
            ans=ans.next;
            if(first!=null)
                first=first.next;
            if(second!=null)
                second = second.next;
            
        }
        return reverse(as.next);
        
        
        
        
    }
}
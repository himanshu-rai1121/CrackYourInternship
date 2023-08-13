/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> mp = new HashMap<>();
        int presum = 0;
        mp.put(presum, dummy);
        while(head!=null)
        {
            presum+=head.val;
            
            if(mp.containsKey(presum))
            {
                ListNode temp = mp.get(presum);
                int sum = presum;
                
                while(temp!=null && temp!=head)
                {
                    temp = temp.next; 
                    sum+=temp.val;
                    if(temp!=head)
                        mp.remove(sum);
                }
                mp.get(presum).next = head.next;
            }
            else
                mp.put(presum, head);
            head = head.next;
        }
        // for(Integer i:mp.keySet())
        //     System.out.print(i+" ");
        return dummy.next;

        
    }
}
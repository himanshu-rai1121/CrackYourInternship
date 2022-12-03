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
    public int getDecimalValue(ListNode head) {
        int answer = 0;
        int length = sizeOfList(head);
        int idx = 1;
        while(head != null) {
            int id = length - idx;
            if(head.val == 1) {
                answer += Math.pow(2, id);
            }
            idx++;
            head = head.next;
        }
        return answer;
    }

    int sizeOfList(ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
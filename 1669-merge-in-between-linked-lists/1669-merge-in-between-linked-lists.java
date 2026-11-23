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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode temp1 = list1;
        ListNode  temp2 = list1;
        while(count < a-1){
            temp1 = temp1.next;
            count++;
        }
        count = 0;
        while(count < b){
            temp2 = temp2.next;
            count++;
        }
        ListNode temp = list2;
        while(temp.next != null){
            temp = temp.next;
        }
        temp1.next = list2;
        temp.next = temp2.next;

        return list1;
    }
}
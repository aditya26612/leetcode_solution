// 2 ms | 46.2 MB
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode newHead=new ListNode();
        dummy.next=newHead;
        ListNode prev = dummy;

        int carry=0;
       
        while((l1!=null && l2!=null )){
            prev = newHead;
            newHead.val=(l1.val+l2.val+carry)%10;
            carry= (l1.val+l2.val+carry)/10;
            l1=l1.next;
            l2=l2.next;
            
            newHead.next=new ListNode();
            newHead=newHead.next;
        }

        while(l1!=null){
            prev = newHead;
            newHead.val=(l1.val+carry)%10;
            carry=(l1.val+carry)/10;
            l1=l1.next;
            
            newHead.next=new ListNode();
            newHead=newHead.next;
        }

        while(l2!=null){
            prev = newHead;
            newHead.val=(l2.val+carry)%10;
            carry=(l2.val+carry)/10;
            l2=l2.next;
            
            newHead.next=new ListNode();
            
            newHead=newHead.next;
        }

        if(carry==1){
            newHead.val=carry;
            newHead.next=null;
            carry=0;
        }
        else{
            prev.next=null;
        }

        return dummy.next;
    }
}
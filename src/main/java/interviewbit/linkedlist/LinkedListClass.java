package src.main.java.interviewbit.linkedlist;

public class LinkedListClass {

    public static ListNode removeNthFromEnd(ListNode A, int B) {

        return removeNthFromEndN(A, B);
    }

    public static ListNode removeNthFromEndN(ListNode head, int k) {
        /* maintain 2 pointers, creater first pointer and move it n nodes, n then start the 2nd pointer
            move 1st n 2nd pointer till first pointer reached end of list */
        ListNode dummy = new ListNode(0), curr = dummy;
        dummy.next = head;
        /* move 1st pointer k places */
        for(int i = 0; (i <= k && curr != null); i++)
            curr = curr.next;

        if(curr == null) return head.next;

        ListNode nodeBeforeRemove = dummy;
        while(curr != null) {
            curr = curr.next;
            nodeBeforeRemove = nodeBeforeRemove.next;
        }

        nodeBeforeRemove.next = nodeBeforeRemove.next.next;

        return dummy.next;
    } // TC: O(N) SC: O(1)


    public static ListNode removeNthFromEnd2N(ListNode head, int k) {
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len  = 0; /* calc length */
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        int posBeforeNodeToRemove = len - k;

        curr = dummy;
        for (int i = 0; i < posBeforeNodeToRemove; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }  // TC: O(2N) SC: O(1)

    public static void main(String[] args) {
       // removeNthFromEndN();
    }


}

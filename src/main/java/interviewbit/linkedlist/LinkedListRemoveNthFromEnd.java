package src.main.java.interviewbit.linkedlist;

/*
    Remove Nth Node from List End
    Problem Description

    Given a linked list A, remove the B-th node from the end of list and return its head.

    For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

    NOTE: If B is greater than the size of the list, remove the first node of the list.

    NOTE: Try doing it using constant additional space.

    Problem Constraints

    1 <= |A| <= 106

    Input Format

    The first argument of input contains a pointer to the head of the linked list.

    The second argument of input contains the integer B.


    Output Format

    Return the head of the linked list after deleting the B-th element from the end.\

    Example Input

    Input 1:

    A = [1, 2, 3, 4, 5]
    B = 2
    Input 2:

    A = [1]
    B = 1

    Example Output

    Output 1:

    [1, 2, 3, 5]
    Output 2:

     []

    Example Explanation

    Explanation 1:

    In the first example, 4 is the second last element.
    Explanation 2:

    In the second example, 1 is the first and the last element.
 */
public class LinkedListRemoveNthFromEnd {

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

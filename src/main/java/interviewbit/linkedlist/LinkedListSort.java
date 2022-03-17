package src.main.java.interviewbit.linkedlist;

/*
    Sort List
    Problem Description
    Sort a linked list, A in O(n log n) time using constant space complexity.

    Problem Constraints
    0 <= |A| = 105

    Input Format
    The first and the only arugment of input contains a pointer to the head of the linked list, A.

    Output Format
    Return a pointer to the head of the sorted linked list.

    Example Input
    Input 1:
    A = [3, 4, 2, 8]
    Input 2: A = [1]

    Example Output
    Output 1: [2, 3, 4, 8]
    Output 2: [1]

    Example Explanation
    Explanation 1: The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
    Explanation 2: The sorted form of [1] is [1].
 */
public class LinkedListSort {
    public ListNode sortList(ListNode A) {

        return sort(A);
    }

    public ListNode sort(ListNode head) {

        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode m = findMid(head);
        ListNode left = head, right = m.next;
        m.next = null;
        ListNode mergeLeft = mergeSort(left);
        ListNode mergeRight = mergeSort(right);
        return merge(mergeLeft, mergeRight);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode mergedList = new ListNode(0), curr = mergedList;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        curr.next = (left == null) ? right : left;

        return mergedList.next;
    }

    public ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

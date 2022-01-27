package src.main.java.interviewbit.linkedlist;

/*
    Copy List

    Problem Description

    A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

    Return a deep copy of the list.

    Problem Constraints

    0 <= |A| <= 106

    Input Format

    The first argument of input contains a pointer to the head of linked list A.

    Output Format

    Return a pointer to the head of the required linked list.

    Example Input

    Given list
       1 -> 2 -> 3
    with random pointers going from
      1 -> 3
      2 -> 1
      3 -> 1

    Example Output

       1 -> 2 -> 3
    with random pointers going from
      1 -> 3
      2 -> 1
      3 -> 1

    Example Explanation

    You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
public class CopyList {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */

    public RandomListNode copyRandomList(RandomListNode head) {

        return copyOfList(head);
    }

    /*
        Create copy of List with pointers
    */
    public RandomListNode copyOfList(RandomListNode head) {

        if (head == null) return null;

        // 1. combine n interleave list
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode node = new RandomListNode(curr.label);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }

        // 2. update random pointer for new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) curr.next.random = curr.random.next;

            curr = curr.next.next;
        }

        // 3. detach newly created nodes
        curr = head;
        RandomListNode head2 = curr.next, p = curr.next;
        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;
            if (curr != null) {
                p.next = p.next.next;
                p = p.next;
            }
        }

        return head2;
    }

}

package src.main.java.interviewbit.linkedlist;

public class FlattenSinglyLinkedList {
    /*
class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
*/
    public FlattenListNode flatten(FlattenListNode root) {
        if(root == null || root.right == null) return root;

        return flattenedNode(root);
    }

    public FlattenListNode flattenedNode(FlattenListNode head) {
        FlattenListNode curr = head, curr_merged = null;

        while(curr != null) {
            FlattenListNode left = curr, right = curr_merged;
            curr_merged = merge(left, right);
            curr = curr.right;
        }

        return curr_merged;
    }


    public FlattenListNode merge(FlattenListNode left, FlattenListNode right) {
        FlattenListNode head = new FlattenListNode(-1), curr = head;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                curr.down = left;
                left = left.down;
            } else {
                curr.down = right;
                right = right.down;
            }

            curr = curr.down;
        }

        curr.down = (left == null) ? right : left;

        return head.down;
    }
}

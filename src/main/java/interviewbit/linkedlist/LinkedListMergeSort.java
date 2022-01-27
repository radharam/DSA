package src.main.java.interviewbit.linkedlist;

public class LinkedListMergeSort {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        return mergedList(A, B);
    }

    public ListNode mergedList(ListNode A, ListNode B) {
        if(A == null) return B;
        else if(B == null) return A;

        ListNode mergedList = new ListNode(0), curr = mergedList;

        while(A != null && B != null) {
            if(A.val <= B.val) {
                curr.next = A;
                curr = curr.next;
                A = A.next;
            } else {
                curr.next = B;
                curr = curr.next;
                B = B.next;
            }
        }

        //mergedList = mergedList.next;
        while(A != null){
            curr.next = A;
            curr = curr.next;
            A = A.next;
        }

        while(B != null) {
            curr.next = B;
            curr = curr.next;
            B = B.next;
        }

        return mergedList.next;
    }

    public ListNode mergedListOptimized(ListNode A, ListNode B) {

        ListNode mergedList = new ListNode(0), curr = mergedList;

        while(A != null && B != null) {
            if(A.val <= B.val) {
                curr.next = A;
                A = A.next;
            } else {
                curr.next = B;
                B = B.next;
            }

            curr = curr.next;
        }

        curr.next = (A == null) ? B : A;

        return mergedList.next;
    }
}
